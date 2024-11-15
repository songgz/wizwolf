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


-- ----------------------------
-- Table structure for ad_client
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_client";
CREATE TABLE "wizwolf"."ad_client" (
                                       "ad_client_id" numeric(10,0) NOT NULL,
                                       "ad_org_id" numeric(10,0) NOT NULL,
                                       "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                       "created" timestamp(6) NOT NULL DEFAULT now(),
                                       "createdby" numeric(10,0) NOT NULL,
                                       "updated" timestamp(6) NOT NULL DEFAULT now(),
                                       "updatedby" numeric(10,0) NOT NULL,
                                       "value" varchar(40) COLLATE "pg_catalog"."default" NOT NULL,
                                       "name" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
                                       "description" varchar(255) COLLATE "pg_catalog"."default",
                                       "smtphost" varchar(60) COLLATE "pg_catalog"."default",
                                       "requestemail" varchar(60) COLLATE "pg_catalog"."default",
                                       "requestuser" varchar(60) COLLATE "pg_catalog"."default",
                                       "requestuserpw" varchar(20) COLLATE "pg_catalog"."default",
                                       "requestfolder" varchar(20) COLLATE "pg_catalog"."default",
                                       "ad_language" varchar(6) COLLATE "pg_catalog"."default",
                                       "ismultilingualdocument" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "issmtpauthorization" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "isusebetafunctions" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "ldapquery" varchar(255) COLLATE "pg_catalog"."default",
                                       "modelvalidationclasses" varchar(255) COLLATE "pg_catalog"."default",
                                       "autoarchive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "mmpolicy" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'F'::bpchar,
                                       "emailtest" char(1) COLLATE "pg_catalog"."default",
                                       "isserveremail" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "documentdir" varchar(60) COLLATE "pg_catalog"."default",
                                       "ispostimmediate" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "iscostimmediate" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "storeattachmentsonfilesystem" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "windowsattachmentpath" varchar(255) COLLATE "pg_catalog"."default",
                                       "unixattachmentpath" varchar(255) COLLATE "pg_catalog"."default",
                                       "storearchiveonfilesystem" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "windowsarchivepath" varchar(255) COLLATE "pg_catalog"."default",
                                       "unixarchivepath" varchar(255) COLLATE "pg_catalog"."default",
                                       "isuseasp" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                       "ad_replicationstrategy_id" numeric(10,0),
                                       "ad_emailconfig_id" numeric(10,0) DEFAULT NULL::numeric,
                                       "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Records of ad_client
-- ----------------------------
INSERT INTO "wizwolf"."ad_client" VALUES (11, 0, 'Y', '2006-08-10 20:22:41', 0, '2017-07-31 21:36:59', 0, 'GardenWorld', 'GardenWorld', 'GardenWorld', NULL, 'you @ company.org', 'you', 'yourpwd', 'request', 'en_US', 'N', 'N', 'Y', NULL, 'compiere.model.MyValidator', 'N', 'F', NULL, 'N', NULL, 'N', 'Y', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, 50000, NULL);
INSERT INTO "wizwolf"."ad_client" VALUES (0, 0, 'Y', '2006-08-10 20:22:41', 0, '2009-09-15 08:00:29', 0, 'SYSTEM', 'System', 'System Client', NULL, 'you @ company.org', 'you', 'yourpwd', 'request', 'en_US', 'Y', 'N', 'Y', NULL, NULL, 'N', 'F', NULL, 'N', NULL, 'N', 'N', 'N', NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, '8b2f5420-fb40-11e8-a479-7a0060f0aa01');

-- ----------------------------
-- Indexes structure for table ad_client
-- ----------------------------
CREATE UNIQUE INDEX "ad_client_name" ON "wizwolf"."ad_client" USING btree (
    "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Checks structure for table ad_client
-- ----------------------------
ALTER TABLE "wizwolf"."ad_client" ADD CONSTRAINT "ad_client_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_client" ADD CONSTRAINT "ad_client_isuseasp_check" CHECK (isuseasp = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_client
-- ----------------------------
ALTER TABLE "wizwolf"."ad_client" ADD CONSTRAINT "ad_client_pkey" PRIMARY KEY ("ad_client_id");

-- ----------------------------
-- Foreign Keys structure for table ad_client
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_client" ADD CONSTRAINT "ademailconfig_adclient" FOREIGN KEY ("ad_emailconfig_id") REFERENCES "wizwolf"."ad_emailconfig" ("ad_emailconfig_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_client" ADD CONSTRAINT "adlangu_adclient" FOREIGN KEY ("ad_language") REFERENCES "wizwolf"."ad_language" ("ad_language") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_client" ADD CONSTRAINT "adreplicationstrategy_adclient" FOREIGN KEY ("ad_replicationstrategy_id") REFERENCES "wizwolf"."ad_replicationstrategy" ("ad_replicationstrategy_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_clientinfo
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_clientinfo";
CREATE TABLE "wizwolf"."ad_clientinfo" (
                                           "ad_client_id" numeric(10,0) NOT NULL,
                                           "ad_org_id" numeric(10,0) NOT NULL,
                                           "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                           "created" timestamp(6) NOT NULL DEFAULT now(),
                                           "createdby" numeric(10,0) NOT NULL,
                                           "updated" timestamp(6) NOT NULL DEFAULT now(),
                                           "updatedby" numeric(10,0) NOT NULL,
                                           "isdiscountlineamt" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                           "c_calendar_id" numeric(10,0),
                                           "c_acctschema1_id" numeric(10,0),
                                           "c_uom_volume_id" numeric(10,0),
                                           "c_uom_weight_id" numeric(10,0),
                                           "c_uom_length_id" numeric(10,0),
                                           "c_uom_time_id" numeric(10,0),
                                           "ad_tree_menu_id" numeric(10,0),
                                           "ad_tree_org_id" numeric(10,0),
                                           "ad_tree_bpartner_id" numeric(10,0),
                                           "ad_tree_project_id" numeric(10,0),
                                           "ad_tree_salesregion_id" numeric(10,0),
                                           "ad_tree_product_id" numeric(10,0),
                                           "m_productfreight_id" numeric(10,0),
                                           "c_bpartnercashtrx_id" numeric(10,0),
                                           "keeplogdays" numeric(10,0),
                                           "ad_tree_activity_id" numeric(10,0),
                                           "ad_tree_campaign_id" numeric(10,0),
                                           "logo_id" numeric(10,0),
                                           "logoreport_id" numeric(10,0),
                                           "logoweb_id" numeric(10,0),
                                           "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                           "restorepassword_mailtext_id" numeric(10,0) DEFAULT NULL::numeric,
                                           "filehandler_id" numeric(10,0) DEFAULT NULL::numeric
)
;

-- ----------------------------
-- Records of ad_clientinfo
-- ----------------------------
INSERT INTO "wizwolf"."ad_clientinfo" VALUES (11, 0, 'Y', '2001-03-27 15:44:11', 0, '2004-04-30 01:50:28', 100, 'Y', 102, 101, NULL, NULL, NULL, 101, 10, 104, 103, 105, 108, 102, 122, 112, NULL, 110, 109, NULL, NULL, NULL, NULL, 50001, NULL);
INSERT INTO "wizwolf"."ad_clientinfo" VALUES (0, 0, 'Y', '1999-12-30 10:28:05', 0, '2000-01-02 00:00:00', 0, 'Y', NULL, NULL, NULL, NULL, NULL, NULL, 10, 50, 40, 60, 100, 30, NULL, NULL, 7, NULL, NULL, NULL, NULL, NULL, '5f0bb908-8716-11e9-9d2c-076e837eba03', 50001, NULL);

-- ----------------------------
-- Checks structure for table ad_clientinfo
-- ----------------------------
ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "ad_clientinfo_isdiscountlineamt_check" CHECK (isdiscountlineamt = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));
ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "ad_clientinfo_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_clientinfo
-- ----------------------------
ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "ad_clientinfo_pkey" PRIMARY KEY ("ad_client_id");

-- ----------------------------
-- Foreign Keys structure for table ad_clientinfo
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adclient_adclientinfo" FOREIGN KEY ("ad_client_id") REFERENCES "wizwolf"."ad_client" ("ad_client_id") ON DELETE CASCADE ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreeactivity_adclientinfo" FOREIGN KEY ("ad_tree_activity_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreebpartner_adclientinfo" FOREIGN KEY ("ad_tree_bpartner_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreecampaign_adclientinfo" FOREIGN KEY ("ad_tree_campaign_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreemenu_adclientinfo" FOREIGN KEY ("ad_tree_menu_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreeorg_adclientinfo" FOREIGN KEY ("ad_tree_org_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreeproduct_adclientinfo" FOREIGN KEY ("ad_tree_product_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreeproject_adclientinfo" FOREIGN KEY ("ad_tree_project_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "adtreesalesreg_adclientinfo" FOREIGN KEY ("ad_tree_salesregion_id") REFERENCES "wizwolf"."ad_tree" ("ad_tree_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "c_uom_length_ad_clientinfo" FOREIGN KEY ("c_uom_length_id") REFERENCES "wizwolf"."c_uom" ("c_uom_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "c_uom_time_ad_clientinfo" FOREIGN KEY ("c_uom_time_id") REFERENCES "wizwolf"."c_uom" ("c_uom_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "c_uom_volume_ad_clientinfo" FOREIGN KEY ("c_uom_volume_id") REFERENCES "wizwolf"."c_uom" ("c_uom_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "c_uom_weight_ad_clientinfo" FOREIGN KEY ("c_uom_weight_id") REFERENCES "wizwolf"."c_uom" ("c_uom_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "cacctschema1_adclientinfo" FOREIGN KEY ("c_acctschema1_id") REFERENCES "wizwolf"."c_acctschema" ("c_acctschema_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "cbpartnercashtrx_adclientinfo" FOREIGN KEY ("c_bpartnercashtrx_id") REFERENCES "wizwolf"."c_bpartner" ("c_bpartner_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "ccalendar_adclientinfo" FOREIGN KEY ("c_calendar_id") REFERENCES "wizwolf"."c_calendar" ("c_calendar_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "filehandler_adclientinfo" FOREIGN KEY ("filehandler_id") REFERENCES "wizwolf"."ad_appregistration" ("ad_appregistration_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "logo_adclientinfo" FOREIGN KEY ("logo_id") REFERENCES "wizwolf"."ad_image" ("ad_image_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "logoreport_adclientinfo" FOREIGN KEY ("logoreport_id") REFERENCES "wizwolf"."ad_image" ("ad_image_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "logoweb_adclientinfo" FOREIGN KEY ("logoweb_id") REFERENCES "wizwolf"."ad_image" ("ad_image_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "mproductfreight_adclientinfo" FOREIGN KEY ("m_productfreight_id") REFERENCES "wizwolf"."m_product" ("m_product_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_clientinfo" ADD CONSTRAINT "restorepasswordmailtext_adclie" FOREIGN KEY ("restorepassword_mailtext_id") REFERENCES "wizwolf"."r_mailtext" ("r_mailtext_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_org
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_org";
CREATE TABLE "wizwolf"."ad_org" (
                                    "ad_org_id" numeric(10,0) NOT NULL,
                                    "ad_client_id" numeric(10,0) NOT NULL,
                                    "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                    "created" timestamp(6) NOT NULL DEFAULT now(),
                                    "createdby" numeric(10,0) NOT NULL,
                                    "updated" timestamp(6) NOT NULL DEFAULT now(),
                                    "updatedby" numeric(10,0) NOT NULL,
                                    "value" varchar(40) COLLATE "pg_catalog"."default" NOT NULL,
                                    "name" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
                                    "description" varchar(255) COLLATE "pg_catalog"."default",
                                    "issummary" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                    "ad_replicationstrategy_id" numeric(10,0),
                                    "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                    "parent_org_id" numeric(10,0) DEFAULT NULL::numeric
)
;

-- ----------------------------
-- Records of ad_org
-- ----------------------------
INSERT INTO "wizwolf"."ad_org" VALUES (11, 11, 'Y', '2001-03-27 15:44:11', 0, '2001-05-09 22:18:12', 0, 'HQ', 'HQ', 'GardenWorld HQ!', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (12, 11, 'Y', '2001-05-09 21:51:04', 100, '2008-09-22 13:16:22', 100, 'Store Central', 'Store Central', 'GardenWorld Store!', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50000, 11, 'Y', '2008-09-22 13:13:23', 100, '2008-09-22 13:13:23', 100, 'Furniture', 'Furniture', 'Furniture', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50001, 11, 'Y', '2008-09-22 13:13:49', 100, '2008-09-22 13:13:49', 100, 'Fertilizer', 'Fertilizer', 'Fertilizer', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50002, 11, 'Y', '2008-09-22 13:14:31', 100, '2008-09-22 13:14:31', 100, 'Store North', 'Store North', 'Store North', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50004, 11, 'Y', '2008-09-22 13:15:12', 100, '2008-09-22 13:15:12', 100, 'Store South', 'Store South', 'Store South', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50005, 11, 'Y', '2008-09-22 13:15:40', 100, '2008-09-22 13:15:40', 100, 'Store East', 'Store East', 'Store East', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50006, 11, 'Y', '2008-09-22 13:16:08', 100, '2008-09-22 13:16:08', 100, 'Store West', 'Store West', 'Store West', 'N', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (50007, 11, 'Y', '2008-09-22 13:16:35', 100, '2008-09-22 13:16:35', 100, 'Stores', 'Stores', NULL, 'Y', NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_org" VALUES (0, 0, 'Y', '1999-11-12 20:28:56', 0, '2000-01-02 00:00:00', 0, '0', '*', 'All Organizations', 'N', NULL, 'a3e5c878-fb40-11e8-a479-7a0060f0aa01', NULL);

-- ----------------------------
-- Indexes structure for table ad_org
-- ----------------------------
CREATE UNIQUE INDEX "ad_org_value" ON "wizwolf"."ad_org" USING btree (
    "ad_client_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "value" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Checks structure for table ad_org
-- ----------------------------
ALTER TABLE "wizwolf"."ad_org" ADD CONSTRAINT "ad_org_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_org
-- ----------------------------
ALTER TABLE "wizwolf"."ad_org" ADD CONSTRAINT "ad_org_pkey" PRIMARY KEY ("ad_org_id");

-- ----------------------------
-- Foreign Keys structure for table ad_org
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_org" ADD CONSTRAINT "ad_org__ad_repli_ad_replica" FOREIGN KEY ("ad_replicationstrategy_id") REFERENCES "wizwolf"."ad_replicationstrategy" ("ad_replicationstrategy_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_org" ADD CONSTRAINT "adclient_adorg" FOREIGN KEY ("ad_client_id") REFERENCES "wizwolf"."ad_client" ("ad_client_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_org" ADD CONSTRAINT "parentorg_adorg" FOREIGN KEY ("parent_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_orginfo
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_orginfo";
CREATE TABLE "wizwolf"."ad_orginfo" (
                                        "ad_org_id" numeric(10,0) NOT NULL,
                                        "ad_client_id" numeric(10,0) NOT NULL,
                                        "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                        "created" timestamp(6) NOT NULL DEFAULT now(),
                                        "createdby" numeric(10,0) NOT NULL,
                                        "updated" timestamp(6) NOT NULL DEFAULT now(),
                                        "updatedby" numeric(10,0) NOT NULL,
                                        "c_location_id" numeric(10,0),
                                        "duns" char(11) COLLATE "pg_catalog"."default" NOT NULL,
                                        "taxid" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
                                        "pa_goal_id" numeric(10,0),
                                        "supervisor_id" numeric(10,0),
                                        "parent_org_id" numeric(10,0),
                                        "ad_orgtype_id" numeric(10,0),
                                        "m_warehouse_id" numeric(10,0),
                                        "transferbank_id" numeric(10,0),
                                        "transfercashbook_id" numeric(10,0),
                                        "receiptfootermsg" varchar(1023) COLLATE "pg_catalog"."default",
                                        "dropship_warehouse_id" numeric(10,0),
                                        "c_calendar_id" numeric(10,0),
                                        "logo_id" numeric(10,0),
                                        "phone" varchar(40) COLLATE "pg_catalog"."default",
                                        "phone2" varchar(40) COLLATE "pg_catalog"."default",
                                        "fax" varchar(40) COLLATE "pg_catalog"."default",
                                        "email" varchar(60) COLLATE "pg_catalog"."default",
                                        "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
                                        "unidentifiedbpartner_id" numeric(10,0) DEFAULT NULL::numeric,
                                        "unidentifiedardoctype_id" numeric(10,0) DEFAULT NULL::numeric,
                                        "unidentifiedapdoctype_id" numeric(10,0) DEFAULT NULL::numeric,
                                        "corporatebrandingimage_id" numeric(10,0) DEFAULT NULL::numeric,
                                        "ad_emailconfig_id" numeric(10,0) DEFAULT NULL::numeric,
                                        "emailtest" char(1) COLLATE "pg_catalog"."default" DEFAULT NULL::bpchar,
                                        "requestuserpw" varchar(20) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Records of ad_orginfo
-- ----------------------------
INSERT INTO "wizwolf"."ad_orginfo" VALUES (11, 11, 'Y', '2001-03-27 15:44:11', 0, '2004-04-17 00:49:38', 100, 114, '??         ', '?', NULL, 101, NULL, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (12, 11, 'Y', '2001-05-11 18:30:03', 100, '2008-09-24 14:47:27', 100, 121, '?          ', '?', NULL, 102, 11, 101, 104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50000, 11, 'Y', '2008-09-22 13:13:25', 100, '2008-09-22 13:13:25', 100, NULL, '?          ', '?', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50001, 11, 'Y', '2008-09-22 13:13:50', 100, '2008-09-22 13:13:50', 100, NULL, '?          ', '?', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50002, 11, 'Y', '2008-09-22 13:14:37', 100, '2008-09-24 14:49:06', 100, NULL, '?          ', '?', NULL, NULL, NULL, 101, 50003, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50004, 11, 'Y', '2008-09-22 13:15:19', 100, '2008-09-24 14:50:10', 100, NULL, '?          ', '?', NULL, NULL, NULL, 101, 50004, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50005, 11, 'Y', '2008-09-22 13:15:44', 100, '2008-09-24 14:46:48', 100, NULL, '?          ', '?', NULL, NULL, NULL, 101, 50005, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50006, 11, 'Y', '2008-09-22 13:16:09', 100, '2008-09-24 14:51:12', 100, NULL, '?          ', '?', NULL, NULL, NULL, 101, 50006, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (50007, 11, 'Y', '2008-09-22 13:16:40', 100, '2008-09-22 13:16:40', 100, NULL, '?          ', '?', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "wizwolf"."ad_orginfo" VALUES (0, 0, 'Y', '1999-12-10 17:04:26', 0, '2000-01-02 00:00:00', 0, 109, '0          ', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '5f75ef4e-8716-11e9-9d65-c3eb298f6ccc', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Checks structure for table ad_orginfo
-- ----------------------------
ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "ad_orginfo_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_orginfo
-- ----------------------------
ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "ad_orginfo_pkey" PRIMARY KEY ("ad_org_id");

-- ----------------------------
-- Foreign Keys structure for table ad_orginfo
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "ademailconfig_adorginfo" FOREIGN KEY ("ad_emailconfig_id") REFERENCES "wizwolf"."ad_emailconfig" ("ad_emailconfig_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "adorg_adorginfo" FOREIGN KEY ("ad_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE CASCADE ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "adorgparent_adorginfo" FOREIGN KEY ("parent_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE SET NULL ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "adorgtype_adorginfo" FOREIGN KEY ("ad_orgtype_id") REFERENCES "wizwolf"."ad_orgtype" ("ad_orgtype_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "aduser_adorginfo" FOREIGN KEY ("supervisor_id") REFERENCES "wizwolf"."ad_user" ("ad_user_id") ON DELETE SET NULL ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "c_location_ad_orginfo" FOREIGN KEY ("c_location_id") REFERENCES "wizwolf"."c_location" ("c_location_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "cbank_adorginfo" FOREIGN KEY ("transferbank_id") REFERENCES "wizwolf"."c_bank" ("c_bank_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "ccalendar_adorginfo" FOREIGN KEY ("c_calendar_id") REFERENCES "wizwolf"."c_calendar" ("c_calendar_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "ccashbook_adorginfo" FOREIGN KEY ("transfercashbook_id") REFERENCES "wizwolf"."c_cashbook" ("c_cashbook_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "dropshipwarehouse_adorginfo" FOREIGN KEY ("dropship_warehouse_id") REFERENCES "wizwolf"."m_warehouse" ("m_warehouse_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "logo_adorginfo" FOREIGN KEY ("logo_id") REFERENCES "wizwolf"."ad_image" ("ad_image_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "mwarehouse_adorginfo" FOREIGN KEY ("m_warehouse_id") REFERENCES "wizwolf"."m_warehouse" ("m_warehouse_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "pagoal_adorginfo" FOREIGN KEY ("pa_goal_id") REFERENCES "wizwolf"."pa_goal" ("pa_goal_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "unidentifiedapdoctype_adorginf" FOREIGN KEY ("unidentifiedapdoctype_id") REFERENCES "wizwolf"."c_doctype" ("c_doctype_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "unidentifiedardoctype_adorginf" FOREIGN KEY ("unidentifiedardoctype_id") REFERENCES "wizwolf"."c_doctype" ("c_doctype_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_orginfo" ADD CONSTRAINT "unidentifiedbpartner_adorginfo" FOREIGN KEY ("unidentifiedbpartner_id") REFERENCES "wizwolf"."c_bpartner" ("c_bpartner_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_preference
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_preference";
CREATE TABLE "wizwolf"."ad_preference" (
                                           "ad_preference_id" numeric(10,0) NOT NULL,
                                           "ad_client_id" numeric(10,0) NOT NULL,
                                           "ad_org_id" numeric(10,0) NOT NULL,
                                           "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                           "created" timestamp(6) NOT NULL DEFAULT now(),
                                           "createdby" numeric(10,0) NOT NULL,
                                           "updated" timestamp(6) NOT NULL DEFAULT now(),
                                           "updatedby" numeric(10,0) NOT NULL,
                                           "ad_window_id" numeric(10,0),
                                           "ad_user_id" numeric(10,0),
                                           "attribute" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
                                           "value" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
                                           "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Records of ad_preference
-- ----------------------------
INSERT INTO "wizwolf"."ad_preference" VALUES (112, 11, 0, 'Y', '2002-08-10 18:36:59', 100, '2002-08-10 18:36:59', 0, 132, NULL, 'GL_Category_ID', '108', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (102, 11, 0, 'Y', '2001-03-27 15:44:24', 0, '2001-03-27 15:44:24', 0, NULL, NULL, 'C_Country_ID', '100', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (103, 11, 0, 'Y', '2001-03-27 15:44:25', 0, '2001-03-27 15:44:25', 0, NULL, NULL, 'C_ProjectStatus_ID', '100', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (106, 11, 0, 'Y', '2002-02-17 21:42:07', 100, '2002-02-17 21:42:07', 0, 184, NULL, 'C_DocType_ID', '122', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (107, 11, 0, 'Y', '2002-02-17 21:42:51', 100, '2002-02-17 21:42:51', 0, 183, NULL, 'C_DocTypeTarget_ID', '123', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (108, 11, 0, 'Y', '2002-02-17 21:43:32', 100, '2002-02-17 21:43:32', 0, 167, NULL, 'C_DocTypeTarget_ID', '116', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (109, 11, 0, 'Y', '2002-02-17 21:44:00', 100, '2002-02-17 21:44:00', 0, 195, NULL, 'C_DocType_ID', '119', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (110, 11, 0, 'Y', '2002-02-22 22:59:56', 100, '2002-02-22 22:59:56', 0, 194, NULL, 'C_Charge_ID', '100', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (111, 11, 0, 'Y', '2002-03-20 15:27:04', 100, '2002-03-20 15:27:04', 0, 181, NULL, 'C_DocTypeTarget_ID', '126', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (114, 11, 0, 'Y', '2003-01-14 00:28:23', 100, '2003-01-14 00:28:23', 0, 189, NULL, 'DataType', 'S', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (116, 11, 0, 'Y', '2003-06-05 12:49:26', 100, '2003-06-05 12:49:26', 100, 143, NULL, 'C_DocTypeTarget_ID', '135', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (113, 0, 0, 'Y', '2003-01-11 01:40:01', 0, '2000-01-02 00:00:00', 0, 103, NULL, 'Type', 'S', 'a3ed05ac-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_preference" VALUES (50000, 0, 0, 'Y', '2007-12-17 01:34:17', 0, '2007-12-17 01:34:17', 0, 53004, NULL, 'AD_Org_ID', '0', 'a3ed061a-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_preference" VALUES (50001, 0, 0, 'Y', '2007-12-17 03:24:43', 0, '2007-12-17 03:24:43', 0, 53005, NULL, 'Action', 'C', 'a3ed0642-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_preference" VALUES (50002, 0, 0, 'Y', '2008-03-23 20:44:56', 100, '2008-03-23 20:44:56', 100, 53032, NULL, 'AD_Org_ID', '0', 'a3ed0660-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_preference" VALUES (50003, 0, 0, 'Y', '2008-03-23 20:53:52', 100, '2008-03-23 20:53:52', 100, 53034, NULL, 'AD_Org_ID', '0', 'a3ed0688-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_preference" VALUES (50004, 0, 0, 'Y', '2008-03-23 20:54:30', 100, '2008-03-23 20:54:30', 100, 53035, NULL, 'AD_Org_ID', '0', 'a3ed06b0-fb40-11e8-a479-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_preference" VALUES (1000000, 0, 0, 'Y', '2018-03-05 11:30:28', 100, '2018-03-05 11:30:28', 100, NULL, 100, 'Language', 'English', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000001, 0, 0, 'Y', '2018-03-05 11:30:28', 100, '2018-03-05 11:30:28', 100, NULL, 100, 'Role', '102', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000002, 0, 0, 'Y', '2018-03-05 11:30:29', 100, '2018-03-05 11:30:29', 100, NULL, 100, 'Client', '11', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000003, 0, 0, 'Y', '2018-03-05 11:30:29', 100, '2018-03-05 11:30:29', 100, NULL, 100, 'Organization', '0', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000004, 0, 0, 'Y', '2018-03-05 11:30:30', 100, '2018-03-05 11:30:30', 100, NULL, 100, 'Warehouse', '0', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000005, 0, 0, 'Y', '2018-03-05 11:30:30', 100, '2018-03-05 11:30:30', 100, NULL, 100, 'AutoCommit', 'Y', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000006, 0, 0, 'Y', '2018-03-05 11:30:31', 100, '2018-03-05 11:30:31', 100, NULL, 100, 'AutoNew', 'Y', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000007, 0, 0, 'Y', '2018-03-05 11:30:31', 100, '2018-03-05 11:30:31', 100, NULL, 100, 'WindowTabPlacement', 'Left', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000008, 0, 0, 'Y', '2018-03-05 11:30:32', 100, '2018-03-05 11:30:32', 100, NULL, 100, 'WindowTabCollapsible', 'N', NULL);
INSERT INTO "wizwolf"."ad_preference" VALUES (1000009, 0, 0, 'Y', '2018-03-05 11:30:32', 100, '2019-12-01 04:30:48', 0, NULL, 100, 'MenuCollapsed', 'Y', NULL);

-- ----------------------------
-- Indexes structure for table ad_preference
-- ----------------------------
CREATE UNIQUE INDEX "ad_preference_attribute" ON "wizwolf"."ad_preference" USING btree (
    "ad_client_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "ad_org_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "ad_window_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "ad_user_id" "pg_catalog"."numeric_ops" ASC NULLS LAST,
    "attribute" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Checks structure for table ad_preference
-- ----------------------------
ALTER TABLE "wizwolf"."ad_preference" ADD CONSTRAINT "ad_preference_isactive_check" CHECK (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]));

-- ----------------------------
-- Primary Key structure for table ad_preference
-- ----------------------------
ALTER TABLE "wizwolf"."ad_preference" ADD CONSTRAINT "ad_preference_pkey" PRIMARY KEY ("ad_preference_id");

-- ----------------------------
-- Foreign Keys structure for table ad_preference
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_preference" ADD CONSTRAINT "ad_preference_client" FOREIGN KEY ("ad_client_id") REFERENCES "wizwolf"."ad_client" ("ad_client_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_preference" ADD CONSTRAINT "ad_preference_org" FOREIGN KEY ("ad_org_id") REFERENCES "wizwolf"."ad_org" ("ad_org_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_preference" ADD CONSTRAINT "ad_user_preference" FOREIGN KEY ("ad_user_id") REFERENCES "wizwolf"."ad_user" ("ad_user_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;
-- ALTER TABLE "wizwolf"."ad_preference" ADD CONSTRAINT "ad_window_preference" FOREIGN KEY ("ad_window_id") REFERENCES "wizwolf"."ad_window" ("ad_window_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


-- ----------------------------
-- Table structure for ad_session
-- ----------------------------
DROP TABLE IF EXISTS "wizwolf"."ad_session";
CREATE TABLE "wizwolf"."ad_session" (
                                        "ad_session_id" numeric(10,0) NOT NULL,
                                        "ad_client_id" numeric(10,0) NOT NULL,
                                        "ad_org_id" numeric(10,0) NOT NULL,
                                        "isactive" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'Y'::bpchar,
                                        "created" timestamp(6) NOT NULL DEFAULT now(),
                                        "createdby" numeric(10,0) NOT NULL,
                                        "updated" timestamp(6) NOT NULL DEFAULT now(),
                                        "updatedby" numeric(10,0) NOT NULL,
                                        "websession" varchar(40) COLLATE "pg_catalog"."default",
                                        "remote_addr" varchar(60) COLLATE "pg_catalog"."default",
                                        "remote_host" varchar(120) COLLATE "pg_catalog"."default",
                                        "processed" char(1) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'N'::bpchar,
                                        "description" varchar(255) COLLATE "pg_catalog"."default",
                                        "ad_role_id" numeric(10,0),
                                        "logindate" timestamp(6),
                                        "uuid" varchar(36) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Records of ad_session
-- ----------------------------
INSERT INTO "wizwolf"."ad_session" VALUES (1000000, 0, 0, 'Y', '2015-02-25 23:40:32', 100, '2015-02-25 23:41:02', 100, NULL, '192.168.59.3', 'Victors-Mac-Book-Pro.local', 'Y', 'Release 3.8.0_2015-03-01 ADempiere', 0, '2015-02-25 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000001, 0, 0, 'Y', '2017-08-01 00:35:15', 100, '2017-08-01 00:55:53', 100, NULL, '10.1.1.158', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-07-31 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000002, 0, 0, 'Y', '2017-08-01 00:56:16', 100, '2017-08-01 00:56:37', 100, NULL, '10.1.1.158', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-07-31 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000003, 0, 0, 'Y', '2017-08-01 01:10:46', 100, '2017-08-01 01:16:50', 100, NULL, '10.1.1.158', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-07-31 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000004, 0, 0, 'Y', '2017-08-01 01:25:44', 100, '2017-08-01 01:53:47', 100, NULL, '10.1.1.158', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-07-31 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000005, 0, 0, 'Y', '2017-08-01 02:04:26', 100, '2017-08-01 02:04:26', 100, NULL, '10.1.1.158', 'MacBook-Pro-de-Victor.local', 'N', 'Release 3.9.0_2017-07-31 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000006, 0, 0, 'Y', '2017-08-01 02:59:11', 100, '2017-08-01 03:00:50', 100, NULL, '10.1.1.158', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-07-31 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000007, 0, 0, 'Y', '2017-08-01 11:16:00', 100, '2017-08-01 11:16:26', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000008, 0, 0, 'Y', '2017-08-01 11:17:17', 100, '2017-08-01 11:17:42', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (50001, 0, 0, 'Y', '2017-08-01 11:19:57', 100, '2017-08-01 11:19:57', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'N', 'Release 1.0.0_2011-09-01 ADempiere 20140318-1254', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000009, 0, 0, 'Y', '2017-08-01 11:20:38', 100, '2017-08-01 11:20:58', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000010, 0, 0, 'Y', '2017-08-01 11:21:50', 100, '2017-08-01 11:22:00', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000012, 0, 0, 'Y', '2017-08-01 12:05:08', 100, '2017-08-01 12:08:34', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000013, 0, 0, 'Y', '2017-08-01 12:08:44', 100, '2017-08-01 12:08:53', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000015, 0, 0, 'Y', '2017-08-01 12:09:48', 100, '2017-08-01 12:10:38', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000016, 0, 0, 'Y', '2017-08-01 12:10:41', 100, '2017-08-01 12:10:50', 100, NULL, '10.10.1.57', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000019, 0, 0, 'Y', '2017-08-01 13:21:17', 0, '2017-08-01 13:21:28', 0, NULL, '172.20.10.4', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000021, 0, 0, 'Y', '2017-08-01 13:26:29', 100, '2017-08-01 13:29:41', 100, NULL, '172.20.10.4', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000025, 0, 0, 'Y', '2017-08-01 13:58:19', 100, '2017-08-01 14:09:55', 100, NULL, '172.20.10.4', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.0_2017-08-01 ADempiere', 0, '2017-08-01 00:00:00', NULL);
INSERT INTO "wizwolf"."ad_session" VALUES (1000027, 0, 0, 'Y', '2018-12-26 10:01:48', 100, '2018-12-26 10:03:35', 100, NULL, '127.0.0.1', 'e-Evolution.local', 'Y', 'Release 3.9.1_2019-01-01 ADempiere', 0, '2018-12-26 00:00:00', '906295ca-0927-11e9-9a2f-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_session" VALUES (1000029, 0, 0, 'Y', '2018-12-26 11:27:03', 100, '2018-12-26 11:27:59', 100, NULL, '172.20.10.8', 'e-Evolution.local', 'Y', 'Release 3.9.1_2019-01-01 ADempiere', 0, '2018-12-26 00:00:00', '76401670-0933-11e9-bde7-7a0060f0aa01');
INSERT INTO "wizwolf"."ad_session" VALUES (1000030, 0, 0, 'Y', '2019-05-03 23:39:02', 100, '2019-05-03 23:41:04', 100, NULL, '192.168.1.72', 'e-Evolution.local', 'Y', 'Release 3.9.2_2019-05-03 ADempiere', 0, '2019-05-03 00:00:00', '8a84c8f8-6e26-11e9-8414-0242ac120002');
INSERT INTO "wizwolf"."ad_session" VALUES (1000031, 0, 0, 'Y', '2019-05-03 23:41:09', 100, '2019-05-03 23:41:18', 100, NULL, '192.168.1.72', 'e-Evolution.local', 'Y', 'Release 3.9.2_2019-05-03 ADempiere', 0, '2019-05-03 00:00:00', 'd626da12-6e26-11e9-a799-0242ac120002');
INSERT INTO "wizwolf"."ad_session" VALUES (1000034, 0, 0, 'Y', '2019-05-03 23:42:29', 100, '2019-05-03 23:46:29', 100, NULL, '192.168.1.72', 'e-Evolution.local', 'Y', 'Release 3.9.2_2019-05-03 ADempiere', 0, '2019-05-03 00:00:00', '060ba7bc-6e27-11e9-b8d2-0242ac120002');
INSERT INTO "wizwolf"."ad_session" VALUES (1000035, 0, 0, 'Y', '2019-05-03 23:46:32', 100, '2019-05-03 23:46:40', 100, NULL, '192.168.1.72', 'e-Evolution.local', 'Y', 'Release 3.9.2_2019-05-03 ADempiere', 0, '2019-05-03 00:00:00', '96e6339c-6e27-11e9-aeef-0242ac120002');
INSERT INTO "wizwolf"."ad_session" VALUES (1000036, 0, 0, 'Y', '2019-12-01 09:29:05', 100, '2019-12-01 09:31:37', 100, NULL, '127.0.0.1', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.3_2019-12-01 ADempiere', 0, '2019-12-01 00:00:00', '5196e7d3-e674-47a1-af76-186c7875aa8f');
INSERT INTO "wizwolf"."ad_session" VALUES (1000037, 0, 0, 'Y', '2019-12-01 09:57:41', 100, '2019-12-01 09:57:46', 100, NULL, '127.0.0.1', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.3_2019-12-01 ADempiere', 0, '2019-12-01 00:00:00', 'bafdc131-6d68-4a82-90f2-0b58e271bac0');
INSERT INTO "wizwolf"."ad_session" VALUES (1000038, 0, 0, 'Y', '2019-12-01 14:02:36', 100, '2019-12-01 14:02:44', 100, NULL, '127.0.0.1', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.3_2019-12-01 ADempiere', 0, '2019-12-01 00:00:00', '78b0d81f-f154-4f8c-ad0b-76fb3135741f');
INSERT INTO "wizwolf"."ad_session" VALUES (1000039, 11, 11, 'Y', '2019-12-01 14:02:52', 100, '2019-12-01 14:03:04', 100, NULL, '127.0.0.1', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.3_2019-12-01 ADempiere', 102, '2019-12-01 00:00:00', '2b847b9a-3488-4bc1-999b-1a85690cf936');
INSERT INTO "wizwolf"."ad_session" VALUES (1000040, 11, 11, 'Y', '2019-12-01 14:03:09', 100, '2019-12-01 14:03:15', 100, NULL, '127.0.0.1', 'MacBook-Pro-de-Victor.local', 'Y', 'Release 3.9.3_2019-12-01 ADempiere', 102, '2019-12-01 00:00:00', '1400ff4b-f9f8-4c00-97f6-566f6fa4f7d8');
INSERT INTO "wizwolf"."ad_session" VALUES (1000042, 11, 11, 'Y', '2023-01-17 19:14:48', 100, '2023-01-17 19:15:03', 100, NULL, '192.168.100.7', 'MacBook-Pro-de-Victor.local', 'Y', 'Last Connection: Jan 17, 2023, 7:15:03 PM CST', 102, '2023-01-17 00:00:00', '55810a4d-2158-4d6b-bd46-c7e9d0546a33');
INSERT INTO "wizwolf"."ad_session" VALUES (1000041, 0, 0, 'Y', '2023-01-17 19:12:39', 100, '2023-01-17 19:14:39', 100, NULL, '127.0.0.1', 'MacBook-Pro-de-Victor.local', 'Y', 'Last Connection: Jan 17, 2023, 7:14:39 PM CST', 0, '2023-01-17 00:00:00', '3e24308e-f8ec-480f-8320-dacba109a4d5');
INSERT INTO "wizwolf"."ad_session" VALUES (1000043, 11, 0, 'Y', '2023-02-16 04:53:33', 101, '2023-02-16 04:54:15', 101, NULL, '192.168.0.102', 'XTZJ-20210226XO', 'N', 'Last Connection: Feb 16, 2023, 4:54:15 AM CST', 102, '2023-02-16 00:00:00', '7fb9413c-33e1-473d-81f6-c22db8563291');
INSERT INTO "wizwolf"."ad_session" VALUES (1000047, 0, 0, 'Y', '2024-11-03 14:20:09', 0, '2024-11-03 14:22:34', 0, NULL, '192.168.0.110', 'XTZJ-20210226XO', 'Y', 'Last Connection: Nov 3, 2024, 2:22:34 PM CST', 0, '2024-11-03 00:00:00', '45adf0d2-f45b-4d95-990c-7017386ea5cb');
INSERT INTO "wizwolf"."ad_session" VALUES (1000044, 11, 50001, 'Y', '2023-03-12 18:45:34', 101, '2023-03-12 18:45:35', 101, NULL, '192.168.0.111', 'XTZJ-20210226XO', 'N', 'Last Connection: Mar 12, 2023, 6:45:35 PM CST', 102, '2023-03-12 00:00:00', '1e3934df-8827-404c-9da3-57b3c3c643ba');
INSERT INTO "wizwolf"."ad_session" VALUES (1000045, 11, 50001, 'Y', '2023-03-26 01:55:22', 101, '2023-03-26 01:57:10', 101, NULL, '192.168.0.111', 'XTZJ-20210226XO', 'Y', 'Last Connection: Mar 26, 2023, 1:57:10 AM CST', 102, '2023-03-26 00:00:00', 'c027cb0e-72d5-4f4b-9d99-faa5633af51b');
INSERT INTO "wizwolf"."ad_session" VALUES (1000048, 0, 0, 'Y', '2024-11-03 16:28:14', 0, '2024-11-03 16:28:34', 0, NULL, '192.168.0.110', 'XTZJ-20210226XO', 'Y', 'Last Connection: Nov 3, 2024, 4:28:34 PM CST', 0, '2024-11-03 00:00:00', '810cd1c5-2e7d-4bb4-83ba-6d83e04207c5');
INSERT INTO "wizwolf"."ad_session" VALUES (1000046, 0, 0, 'Y', '2023-03-26 02:02:01', 0, '2023-03-26 02:02:54', 0, NULL, '192.168.0.111', 'XTZJ-20210226XO', 'Y', 'Last Connection: Mar 26, 2023, 2:02:54 AM CST', 0, '2023-03-26 00:00:00', '317270db-4bda-4996-b8de-fb8e041545b3');
INSERT INTO "wizwolf"."ad_session" VALUES (1000049, 0, 0, 'Y', '2024-11-03 16:52:20', 0, '2024-11-03 16:52:25', 0, NULL, '192.168.0.110', 'XTZJ-20210226XO', 'Y', 'Last Connection: Nov 3, 2024, 4:52:25 PM CST', 0, '2024-11-03 00:00:00', 'cafebc33-12db-429f-b2de-054c0fcbf6d3');
INSERT INTO "wizwolf"."ad_session" VALUES (1000050, 0, 0, 'Y', '2024-11-09 20:14:25', 0, '2024-11-11 09:57:25', 0, NULL, '192.168.0.110', 'XTZJ-20210226XO', 'Y', 'Last Connection: Nov 11, 2024, 9:57:25 AM CST', 0, '2024-11-09 00:00:00', '7a00e32b-f1d7-4802-b5e9-4b880af9a6c4');

-- ----------------------------
-- Primary Key structure for table ad_session
-- ----------------------------
ALTER TABLE "wizwolf"."ad_session" ADD CONSTRAINT "ad_session_pkey" PRIMARY KEY ("ad_session_id");

-- ----------------------------
-- Foreign Keys structure for table ad_session
-- ----------------------------
-- ALTER TABLE "wizwolf"."ad_session" ADD CONSTRAINT "adrole_adsession" FOREIGN KEY ("ad_role_id") REFERENCES "wizwolf"."ad_role" ("ad_role_id") ON DELETE NO ACTION ON UPDATE NO ACTION DEFERRABLE INITIALLY DEFERRED;


