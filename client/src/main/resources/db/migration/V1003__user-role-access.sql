
-- ----------------------------
-- Table structure for ad_user
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_user";
CREATE TABLE "wizwolf"."ad_user" (
                                     "ad_user_id" numeric(10,0) NOT NULL,
                                     "ad_client_id" numeric(10,0) NOT NULL,
                                     "ad_org_id" numeric(10,0) NOT NULL,
                                     "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "created" timestamp(6) NOT NULL DEFAULT now(),
                                     "createdby" numeric(10,0) NOT NULL,
                                     "updated" timestamp(6) NOT NULL DEFAULT now(),
                                     "updatedby" numeric(10,0) NOT NULL,
                                     "name" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
                                     "description" varchar(255) COLLATE "pg_catalog"."default",
                                     "password" varchar(1024) COLLATE "pg_catalog"."default",
                                     "email" varchar(60) COLLATE "pg_catalog"."default",
                                     "supervisor_id" numeric(10,0),
                                     "c_bpartner_id" numeric(10,0),
                                     "processing" char(1) COLLATE "pg_catalog"."default",
                                     "emailuser" varchar(60) COLLATE "pg_catalog"."default",
                                     "emailuserpw" varchar(255) COLLATE "pg_catalog"."default",
                                     "c_bpartner_location_id" numeric(10,0),
                                     "c_greeting_id" numeric(10,0),
                                     "title" varchar(40) COLLATE "pg_catalog"."default",
                                     "comments" varchar(2000) COLLATE "pg_catalog"."default",
                                     "phone" varchar(40) COLLATE "pg_catalog"."default",
                                     "phone2" varchar(40) COLLATE "pg_catalog"."default",
                                     "fax" varchar(40) COLLATE "pg_catalog"."default",
                                     "lastcontact" timestamp(6),
                                     "lastresult" varchar(255) COLLATE "pg_catalog"."default",
                                     "birthday" timestamp(6),
                                     "ad_orgtrx_id" numeric(10,0),
                                     "emailverify" varchar(40) COLLATE "pg_catalog"."default",
                                     "emailverifydate" timestamp(6),
                                     "notificationtype" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'E'::bpchar,
                                     "isfullbpaccess" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "c_job_id" numeric(10,0),
                                     "ldapuser" varchar(60) COLLATE "pg_catalog"."default",
                                     "connectionprofile" char(1) COLLATE "pg_catalog"."default",
                                     "value" varchar(40) COLLATE "pg_catalog"."default",
                                     "userpin" varchar(20) COLLATE "pg_catalog"."default",
                                     "isinpayroll" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "salt" varchar(16) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "issaleslead" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "c_location_id" numeric(10,0) DEFAULT NULL::numeric,
                                     "leadsource" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "leadstatus" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "leadsourcedescription" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "leadstatusdescription" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "c_campaign_id" numeric(10,0) DEFAULT NULL::numeric,
                                     "salesrep_id" numeric(10,0),
                                     "bpname" varchar(60) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "bp_location_id" numeric(10,0) DEFAULT NULL::numeric,
                                     "ad_emailconfig_id" numeric(10,0) DEFAULT NULL::numeric,
                                     "isloginuser" char(1) COLLATE "pg_catalog"."default" DEFAULT 'N'::bpchar,
                                     "isinternaluser" char(1) COLLATE "pg_catalog"."default" DEFAULT 'N'::bpchar,
                                     "iswebstoreuser" char(1) COLLATE "pg_catalog"."default" DEFAULT 'N'::bpchar,
                                     "recentitemsmaxsaved" numeric(10,0) DEFAULT '50'::numeric,
                                     "recentitemsmaxshown" numeric(10,0) DEFAULT '20'::numeric,
                                     "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "isprojectmember" char(1) COLLATE "pg_catalog"."default" DEFAULT 'N'::bpchar,
                                     "isprojectmanager" char(1) COLLATE "pg_catalog"."default" DEFAULT 'N'::bpchar,
                                     "imageurl" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                     "logo_id" numeric(10,0) DEFAULT NULL::numeric,
                                     "isincludeownchanges" char(1) COLLATE "pg_catalog"."default" DEFAULT 'N'::bpchar,
                                     "name2" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Records of ad_user
-- ----------------------------
INSERT INTO "wizwolf"."ad_user" VALUES (104, 11, 0, 'Y', '2002-08-25 00:30:53', 100, '2005-09-16 18:18:35', 100, 'Carl Boss', NULL, NULL, NULL, NULL, 117, NULL, NULL, NULL, NULL, 100, 'Manager', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'E', 'Y', 102, NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N', 'N', 'N', 50, 20, NULL, 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (105, 11, 0, 'Y', '2004-03-23 22:12:22', 100, '2004-03-23 22:12:22', 100, 'Henry Seed', NULL, NULL, NULL, NULL, 120, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'E', 'Y', NULL, NULL, NULL, NULL, NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N', 'N', 'N', 50, 20, NULL, 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (102, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2001-12-08 22:01:24', 100, 'GardenUser', 'GardenUser', 'GardenUser', 'user @ gardenworld.com', 101, 119, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'E', 'Y', NULL, NULL, NULL, 'GardenUser', NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', 'N', 'N', 50, 20, NULL, 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (50001, 11, 0, 'Y', '2009-01-30 19:44:55', 100, '2009-01-30 19:44:55', 100, 'WebService', NULL, 'WebService', NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'X', 'Y', NULL, NULL, NULL, 'WebService', NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', 'N', 'N', 50, 20, NULL, 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (100, 0, 0, 'Y', '1999-12-09 18:15:00', 0, '2005-10-18 07:58:59', 0, 'SuperUser', 'Super User with Access to all levels', 'System', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'E', 'Y', NULL, NULL, NULL, 'SuperUser', NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', 'N', 'N', 50, 20, 'a4bd438e-fb40-11e8-a479-7a0060f0aa01', 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (0, 0, 0, 'Y', '1999-11-12 20:41:43', 0, '2000-01-02 00:00:00', 0, 'System', '** Do not change **', 'System', NULL, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'E', 'Y', NULL, NULL, NULL, 'System', NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', 'N', 'N', 50, 20, 'a4bd46ae-fb40-11e8-a479-7a0060f0aa01', 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (50004, 11, 0, 'Y', '2022-05-11 20:23:24', 100, '2022-05-11 20:23:24', 100, 'Contact of Joe Block', NULL, NULL, NULL, NULL, 118, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'S', 'Y', NULL, NULL, NULL, '50000', NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N', 'N', 'N', 50, 20, 'cfa1f8a0-3ec9-4322-b0db-b64444673de3', 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (103, 11, 0, 'Y', '2001-05-21 21:34:07', 100, '2001-05-21 21:34:07', 100, 'Joe Sales', NULL, NULL, NULL, NULL, 114, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-01-25 00:00:00', '10000003', NULL, NULL, NULL, NULL, 'E', 'Y', NULL, NULL, NULL, 'joesales', NULL, 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'N', 'N', 'N', 50, 20, NULL, 'N', 'N', NULL, NULL, 'N', NULL);
INSERT INTO "wizwolf"."ad_user" VALUES (101, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2023-01-17 19:11:17', 0, 'GardenAdmin', 'GardenAdmin', 'GardenAdmin', 'admin @ gardenworld.com', NULL, 113, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-08-10 00:00:00', 'Invoice: 1000', NULL, NULL, NULL, NULL, 'E', 'Y', 100, NULL, NULL, 'GardenAdmin', '1234', 'N', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', 'N', 'N', 50, 20, 'bef95ce0-1b93-411f-8eb3-170040f94f96', 'N', 'N', NULL, NULL, 'N', NULL);

-- ----------------------------
-- Indexes structure for table ad_user
-- ----------------------------
CREATE INDEX "ad_user_email" ON "wizwolf"."ad_user" USING btree (
    "email" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );
CREATE INDEX "ad_user_value" ON "wizwolf"."ad_user" USING btree (
    "ad_client_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "value" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Checks structure for table ad_user
-- ----------------------------
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isincludeownchanges_check" CHECK (isincludeownchanges = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isinpayroll_check" CHECK (isinpayroll = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isinternaluser_check" CHECK (isinternaluser = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isloginuser_check" CHECK (isloginuser = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isprojectmanager_check" CHECK (isprojectmanager = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isprojectmember_check" CHECK (isprojectmember = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_issaleslead_check" CHECK (issaleslead = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_iswebstoreuser_check" CHECK (iswebstoreuser = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_user
-- ----------------------------
ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_pkey" PRIMARY KEY ("ad_user_id");

-- ----------------------------
-- Foreign Keys structure for table ad_user
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_client" FOREIGN KEY ("ad_client_id") REFERENCES "wizwolf"."ad_client" ("ad_client_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ad_user_org" FOREIGN KEY ("ad_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ademailconfig_aduser" FOREIGN KEY ("ad_emailconfig_id") REFERENCES "wizwolf"."ad_emailconfig" ("ad_emailconfig_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "adorgtrx_aduser" FOREIGN KEY ("ad_orgtrx_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "aduser_supervisor" FOREIGN KEY ("supervisor_id") REFERENCES "wizwolf"."ad_user" ("ad_user_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "cbpartner_aduser" FOREIGN KEY ("c_bpartner_id") REFERENCES "wizwolf"."c_bpartner" ("c_bpartner_id") ON DELETE CASCADE ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "cbplocation_aduser" FOREIGN KEY ("c_bpartner_location_id") REFERENCES "wizwolf"."c_bpartner_location" ("c_bpartner_location_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "ccampaign_aduser" FOREIGN KEY ("c_campaign_id") REFERENCES "wizwolf"."c_campaign" ("c_campaign_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "cgreeting_aduser" FOREIGN KEY ("c_greeting_id") REFERENCES "wizwolf"."c_greeting" ("c_greeting_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "cjob_aduser" FOREIGN KEY ("c_job_id") REFERENCES "wizwolf"."c_job" ("c_job_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "clocation_aduser" FOREIGN KEY ("c_location_id") REFERENCES "wizwolf"."c_location" ("c_location_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user" ADD CONSTRAINT "salesrep_aduser" FOREIGN KEY ("salesrep_id") REFERENCES "wizwolf"."ad_user" ("ad_user_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_role
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_role";
CREATE TABLE "wizwolf"."ad_role" (
                                     "ad_role_id" numeric(10,0) NOT NULL,
                                     "ad_client_id" numeric(10,0) NOT NULL,
                                     "ad_org_id" numeric(10,0) NOT NULL,
                                     "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "created" timestamp(6) NOT NULL DEFAULT now(),
                                     "createdby" numeric(10,0) NOT NULL,
                                     "updated" timestamp(6) NOT NULL DEFAULT now(),
                                     "name" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
                                     "updatedby" numeric(10,0) NOT NULL,
                                     "description" varchar(255) COLLATE "pg_catalog"."default",
                                     "userlevel" char(3) COLLATE "pg_catalog"."default" NOT NULL DEFAULT '  O'::bpchar,
                                     "c_currency_id" numeric(10,0),
                                     "amtapproval" numeric DEFAULT 0,
                                     "ad_tree_menu_id" numeric(10,0),
                                     "ismanual" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "isshowacct" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "ispersonallock" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "ispersonalaccess" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "iscanexport" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "iscanreport" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "supervisor_id" numeric(10,0),
                                     "iscanapproveowndoc" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "isaccessallorgs" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "ischangelog" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "preferencetype" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'C'::bpchar,
                                     "overwritepricelimit" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "isuseuserorgaccess" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "ad_tree_org_id" numeric(10,0),
                                     "confirmqueryrecords" numeric(10,0) NOT NULL DEFAULT 0,
                                     "maxqueryrecords" numeric(10,0) NOT NULL DEFAULT 0,
                                     "connectionprofile" char(1) COLLATE "pg_catalog"."default",
                                     "allow_info_account" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_asset" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_bpartner" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_cashjournal" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_inout" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_invoice" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_order" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_payment" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_product" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_resource" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_schedule" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "userdiscount" numeric(22,0),
                                     "allow_info_mrp" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "allow_info_crp" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                     "isdiscountuptolimitprice" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "isdiscountallowedontotal" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                     "allow_html_view" char(1) COLLATE "pg_catalog"."default" DEFAULT 'Y'::bpchar,
                                     "allow_xls_view" char(1) COLLATE "pg_catalog"."default" DEFAULT 'Y'::bpchar,
                                     "iscanload" char(1) COLLATE "pg_catalog"."default" DEFAULT 'Y'::bpchar,
                                     "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Records of ad_role
-- ----------------------------
INSERT INTO "wizwolf"."ad_role" VALUES (102, 11, 0, 'Y', '2001-03-27 15:44:11', 0, '2005-03-10 02:15:36', 'GardenWorld Admin', 100, 'GardenWorld Admin', ' CO', 100, 500, NULL, 'N', 'Y', 'N', 'N', 'Y', 'Y', NULL, 'Y', 'N', 'N', 'C', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', NULL);
INSERT INTO "wizwolf"."ad_role" VALUES (103, 11, 0, 'Y', '2001-03-27 15:44:11', 0, '2004-11-27 15:33:00', 'GardenWorld User', 100, 'GardenWorld User', '  O', 100, 30, NULL, 'N', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', NULL);
INSERT INTO "wizwolf"."ad_role" VALUES (50004, 11, 0, 'Y', '2009-01-30 19:44:19', 100, '2009-01-30 19:44:19', 'Web Service Execution', 100, NULL, ' CO', 100, 0, NULL, 'Y', 'N', 'N', 'N', 'N', 'N', 101, 'N', 'N', 'Y', 'N', 'N', 'N', NULL, 0, 0, NULL, 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 0, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', NULL);
INSERT INTO "wizwolf"."ad_role" VALUES (0, 0, 0, 'Y', '1999-11-14 16:14:40', 0, '2000-01-02 00:00:00', 'System Administrator', 0, 'System Administrator Role (cannot be changed)', 'S  ', NULL, 0, NULL, 'N', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'C', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'a48d2596-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_role" VALUES (50001, 0, 0, 'N', '2006-12-11 23:47:50', 0, '2008-07-25 10:39:50', 'Packaging User', 100, 'Packaging User', 'S  ', NULL, 0, NULL, 'N', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', NULL, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'a48d3022-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_role" VALUES (50002, 0, 0, 'N', '2008-05-30 17:04:41', 100, '2008-07-25 10:39:47', 'FA User', 100, 'Fixed Asset User', 'S  ', NULL, 0, NULL, 'N', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', NULL, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'Y', 'a48d309a-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_role" VALUES (50008, 0, 0, 'Y', '2013-11-02 12:13:14', 0, '2013-11-02 10:54:18', 'Role Template', 0, NULL, ' CO', NULL, 0, NULL, 'Y', 'N', 'N', 'N', 'Y', 'Y', NULL, 'N', 'N', 'N', 'O', 'N', 'N', NULL, 0, 0, NULL, 'Y', 'N', 'Y', 'N', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'N', 0, 'N', 'N', 'N', 'N', 'Y', 'Y', 'Y', 'a48d3108-fb40-11e8-a479-7a0060f0aa01');

-- ----------------------------
-- Checks structure for table ad_role
-- ----------------------------
ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_role_allow_info_mrp_check" CHECK (allow_info_mrp = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_role_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_role_iscanload_check" CHECK (iscanload = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_role_allow_info_crp_check" CHECK (allow_info_crp = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_role
-- ----------------------------
ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_role_pkey" PRIMARY KEY ("ad_role_id");

-- ----------------------------
-- Foreign Keys structure for table ad_role
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_roleclient" FOREIGN KEY ("ad_client_id") REFERENCES "wizwolf"."ad_client" ("ad_client_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "ad_roleorg" FOREIGN KEY ("ad_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "adtree_adrole" FOREIGN KEY ("ad_tree_menu_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "adtreeorg_adrole" FOREIGN KEY ("ad_tree_org_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "adusersupervisor_adrole" FOREIGN KEY ("supervisor_id") REFERENCES "wizwolf"."ad_user" ("ad_user_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_role" ADD CONSTRAINT "c_currency_ad_role" FOREIGN KEY ("c_currency_id") REFERENCES "wizwolf"."c_currency" ("c_currency_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_user_roles
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_user_roles";
CREATE TABLE "wizwolf"."ad_user_roles" (
                                           "ad_user_id" numeric(10,0) NOT NULL,
                                           "ad_role_id" numeric(10,0) NOT NULL,
                                           "ad_client_id" numeric(10,0) NOT NULL,
                                           "ad_org_id" numeric(10,0) NOT NULL,
                                           "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                           "created" timestamp(6) NOT NULL DEFAULT now(),
                                           "createdby" numeric(10,0) NOT NULL,
                                           "updated" timestamp(6) NOT NULL DEFAULT now(),
                                           "updatedby" numeric(10,0) NOT NULL,
                                           "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                           "isdefault" char(1) COLLATE "pg_catalog"."default" DEFAULT NULL::bpchar
)
;

-- ----------------------------
-- Records of ad_user_roles
-- ----------------------------
INSERT INTO "wizwolf"."ad_user_roles" VALUES (100, 102, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2001-03-27 15:44:12', 0, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (100, 103, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2001-03-27 15:44:12', 0, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (101, 102, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2001-03-27 15:44:12', 0, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (101, 103, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2001-03-27 15:44:12', 0, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (102, 103, 11, 0, 'Y', '2001-03-27 15:44:12', 0, '2001-03-27 15:44:12', 0, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (100, 50004, 11, 11, 'Y', '2009-01-30 19:44:20', 100, '2009-01-30 19:44:20', 100, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (50001, 50004, 11, 0, 'Y', '2009-01-30 19:45:11', 100, '2009-01-30 19:45:11', 100, NULL, NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (100, 50002, 0, 0, 'Y', '2008-05-30 17:04:43', 100, '2008-05-30 17:04:43', 100, '6181c786-8716-11e9-a21c-172f15e85ea1', NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (101, 50002, 0, 0, 'Y', '2008-05-30 21:50:29', 100, '2008-05-30 21:50:29', 100, '6181c86c-8716-11e9-a21d-8b2bf5e7d45d', NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (100, 50008, 0, 0, 'Y', '2013-11-02 12:13:15', 0, '2013-11-02 12:13:15', 0, '6181c8d0-8716-11e9-a21e-23cf61c5224f', NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (0, 50008, 0, 0, 'Y', '2013-11-02 12:13:15', 0, '2013-11-02 12:13:15', 0, '6181c920-8716-11e9-a21f-2fda5df8bba4', NULL);
INSERT INTO "wizwolf"."ad_user_roles" VALUES (100, 0, 0, 0, 'Y', '1999-12-09 21:18:41', 0, '2018-12-26 01:38:27', 0, '6181c97a-8716-11e9-a220-9748c10abd49', 'Y');
INSERT INTO "wizwolf"."ad_user_roles" VALUES (0, 0, 0, 0, 'Y', '1999-11-14 16:17:08', 0, '2000-01-02 00:00:00', 0, '6181c9ca-8716-11e9-a221-2f1b2adc95be', 'Y');

-- ----------------------------
-- Indexes structure for table ad_user_roles
-- ----------------------------
CREATE UNIQUE INDEX "ad_user_role_key" ON "wizwolf"."ad_user_roles" USING btree (
    "ad_role_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "ad_user_id" "pg_catalog"."numeric_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Checks structure for table ad_user_roles
-- ----------------------------
ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "ad_user_roles_isdefault_check" CHECK (isdefault = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "ad_user_roles_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_user_roles
-- ----------------------------
ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "ad_user_roles_pkey" PRIMARY KEY ("ad_user_id", "ad_role_id");

-- ----------------------------
-- Foreign Keys structure for table ad_user_roles
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "ad_userrolesclient" FOREIGN KEY ("ad_client_id") REFERENCES "wizwolf"."ad_client" ("ad_client_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "ad_userrolesorg" FOREIGN KEY ("ad_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "adrole_aduserroles" FOREIGN KEY ("ad_role_id") REFERENCES "wizwolf"."ad_role" ("ad_role_id") ON DELETE CASCADE ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_user_roles" ADD CONSTRAINT "aduser_userroles" FOREIGN KEY ("ad_user_id") REFERENCES "wizwolf"."ad_user" ("ad_user_id") ON DELETE CASCADE ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
