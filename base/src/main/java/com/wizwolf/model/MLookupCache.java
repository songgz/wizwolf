package com.wizwolf.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MLookupCache {
    private static final Logger logger = LoggerFactory.getLogger(MLookupCache.class);
    /**
     *  MLookup Loader starts loading - ignore for now
     *
     *  @param info MLookupInfo
     */
    protected static void loadStart (MLookupInfo info)
    {
    }   //  loadStart

    /**
     *  MLookup Loader ends loading, so add it to cache
     *
     *  @param info
     *  @param lookup
     */
    protected static void loadEnd (MLookupInfo info, HashMap lookup)
    {
        m_loadedLookups.put(info, lookup);
    }   //  loadEnd

    /**
     *  Load from Cache if applicable
     *  Called from MLookup constructor
     *
     * @param info  MLookupInfo to search
     * @param lookupTarget Target HashMap
     * @return true, if lookup found
     */
    protected static boolean loadFromCache (MLookupInfo info, HashMap lookupTarget)
    {
        //  Get the array of existing MLookupInfo
        Object[] keys = null;
        for (int i = 0; keys == null && i < 3; i++)
        {
            //  we may get a ConcurrentModificationException
            try
            {
                keys = m_loadedLookups.keySet().toArray();
            }
            catch (Exception e)
            {
                keys = null;
            }
        }
        //  Load if not found or nothing cached
        if (keys == null || keys.length == 0)
            return false;

        //  search for ir
        for (int i = 0; i < keys.length; i++)
        {
            MLookupInfo key = (MLookupInfo)keys[i];
            //  Window and Query needs to be the same
            if (info.WindowNo == key.WindowNo && info.Query.equals(key.Query))
                return copyLookup (key, lookupTarget);
        }
        return false;
    }   //  loadFromCache

    /**
     *  Copy lookup entries to target
     *  @param key  key of MLookup data to copy
     *  @param lookupTarget HashMap where to load the data
     *  @return true if copied from cache
     */
    private static boolean copyLookup (MLookupInfo key, HashMap lookupTarget)
    {
        HashMap cache = (HashMap)m_loadedLookups.get(key);
        if (cache == null)
            return false;
        //  Nothing cached
        if (cache.size() == 0)
        {
            m_loadedLookups.remove(key);
            return false;
        }

        //  Copy Asynchronously to speed things up
        //	if (cache.size() > ?) copyAsync

        //  copy cache
        //  we can use iterator, as the lookup loading is complete (i.e. no additional entries)
        Iterator iterator = cache.keySet().iterator();
        while (iterator.hasNext())
        {
            Object cacheKey = iterator.next();
            Object cacheData = cache.get(cacheKey);
            lookupTarget.put(cacheKey, cacheData);
        }

        logger.trace("MLookupCache.copyLookup", "Count=" + lookupTarget.size());
        return true;
    }   //  copyLookup

    /**
     *	Clear Static Lookup Cache for Window
     *  @param WindowNo WindowNo of Cache entries to delete
     */
    public static void cacheReset (int WindowNo)
    {
        int startNo = m_loadedLookups.size();
        //  find keys of Lookups to delete
        ArrayList toDelete = new ArrayList();
        Iterator iterator = m_loadedLookups.keySet().iterator();
        while (iterator.hasNext())
        {
            MLookupInfo info = (MLookupInfo)iterator.next();
            if (info.WindowNo == WindowNo)
                toDelete.add(info);
        }

        //  Do the actual delete
        for (int i = 0; i < toDelete.size(); i++)
            m_loadedLookups.remove(toDelete.get(i));
        int endNo = m_loadedLookups.size();
        logger.trace("MLookupCache.cacheReset - WindowNo=" + WindowNo
                + " - " + startNo + " -> " + endNo);
    }	//	cacheReset

    /** Static Lookup data with MLookupInfo -> HashMap  */
    private static HashMap      m_loadedLookups = new HashMap();

    /*************************************************************************/

    /**
     *  Private constructor
     */
    private MLookupCache()
    {
    }   //  MLookupCache

}   //  MLookupCache

