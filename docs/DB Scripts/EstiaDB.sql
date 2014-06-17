--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-06-17 14:34:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 180 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1990 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16462)
-- Name: ROLE; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE "ROLE" (
    id integer NOT NULL,
    type text NOT NULL
);


ALTER TABLE public."ROLE" OWNER TO estiauser;

--
-- TOC entry 173 (class 1259 OID 16468)
-- Name: ES_ROLES_ID_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE "ES_ROLES_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."ES_ROLES_ID_seq" OWNER TO estiauser;

--
-- TOC entry 1991 (class 0 OID 0)
-- Dependencies: 173
-- Name: ES_ROLES_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE "ES_ROLES_ID_seq" OWNED BY "ROLE".id;


--
-- TOC entry 170 (class 1259 OID 16459)
-- Name: USER; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE "USER" (
    id integer NOT NULL,
    username text NOT NULL,
    firstname text,
    lastname text NOT NULL,
    email text NOT NULL,
    telephone text NOT NULL,
    password text,
    type integer NOT NULL
);


ALTER TABLE public."USER" OWNER TO estiauser;

--
-- TOC entry 174 (class 1259 OID 16477)
-- Name: ES_USERS_ID_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE "ES_USERS_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."ES_USERS_ID_seq" OWNER TO estiauser;

--
-- TOC entry 1992 (class 0 OID 0)
-- Dependencies: 174
-- Name: ES_USERS_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE "ES_USERS_ID_seq" OWNED BY "USER".id;


--
-- TOC entry 172 (class 1259 OID 16465)
-- Name: USERROLE; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE "USERROLE" (
    "userId" integer NOT NULL,
    "roleId" integer NOT NULL
);


ALTER TABLE public."USERROLE" OWNER TO estiauser;

--
-- TOC entry 176 (class 1259 OID 16499)
-- Name: ES_USERS_ROLES_ROLE_ID_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE "ES_USERS_ROLES_ROLE_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."ES_USERS_ROLES_ROLE_ID_seq" OWNER TO estiauser;

--
-- TOC entry 1993 (class 0 OID 0)
-- Dependencies: 176
-- Name: ES_USERS_ROLES_ROLE_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE "ES_USERS_ROLES_ROLE_ID_seq" OWNED BY "USERROLE"."roleId";


--
-- TOC entry 175 (class 1259 OID 16493)
-- Name: ES_USERS_ROLES_USER_ID_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE "ES_USERS_ROLES_USER_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."ES_USERS_ROLES_USER_ID_seq" OWNER TO estiauser;

--
-- TOC entry 1994 (class 0 OID 0)
-- Dependencies: 175
-- Name: ES_USERS_ROLES_USER_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE "ES_USERS_ROLES_USER_ID_seq" OWNED BY "USERROLE"."userId";


--
-- TOC entry 178 (class 1259 OID 16519)
-- Name: USERTYPE; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE "USERTYPE" (
    id integer NOT NULL,
    type text
);


ALTER TABLE public."USERTYPE" OWNER TO estiauser;

--
-- TOC entry 177 (class 1259 OID 16517)
-- Name: USERTYPE_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE "USERTYPE_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."USERTYPE_id_seq" OWNER TO estiauser;

--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 177
-- Name: USERTYPE_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE "USERTYPE_id_seq" OWNED BY "USERTYPE".id;


--
-- TOC entry 179 (class 1259 OID 16526)
-- Name: USER_type_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE "USER_type_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."USER_type_seq" OWNER TO estiauser;

--
-- TOC entry 1996 (class 0 OID 0)
-- Dependencies: 179
-- Name: USER_type_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE "USER_type_seq" OWNED BY "USER".type;


--
-- TOC entry 1850 (class 2604 OID 16470)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "ROLE" ALTER COLUMN id SET DEFAULT nextval('"ES_ROLES_ID_seq"'::regclass);


--
-- TOC entry 1848 (class 2604 OID 16479)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USER" ALTER COLUMN id SET DEFAULT nextval('"ES_USERS_ID_seq"'::regclass);


--
-- TOC entry 1849 (class 2604 OID 16528)
-- Name: type; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USER" ALTER COLUMN type SET DEFAULT nextval('"USER_type_seq"'::regclass);


--
-- TOC entry 1851 (class 2604 OID 16495)
-- Name: userId; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USERROLE" ALTER COLUMN "userId" SET DEFAULT nextval('"ES_USERS_ROLES_USER_ID_seq"'::regclass);


--
-- TOC entry 1852 (class 2604 OID 16501)
-- Name: roleId; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USERROLE" ALTER COLUMN "roleId" SET DEFAULT nextval('"ES_USERS_ROLES_ROLE_ID_seq"'::regclass);


--
-- TOC entry 1853 (class 2604 OID 16522)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USERTYPE" ALTER COLUMN id SET DEFAULT nextval('"USERTYPE_id_seq"'::regclass);


--
-- TOC entry 1997 (class 0 OID 0)
-- Dependencies: 173
-- Name: ES_ROLES_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('"ES_ROLES_ID_seq"', 1, false);


--
-- TOC entry 1998 (class 0 OID 0)
-- Dependencies: 174
-- Name: ES_USERS_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('"ES_USERS_ID_seq"', 1, false);


--
-- TOC entry 1999 (class 0 OID 0)
-- Dependencies: 176
-- Name: ES_USERS_ROLES_ROLE_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('"ES_USERS_ROLES_ROLE_ID_seq"', 1, false);


--
-- TOC entry 2000 (class 0 OID 0)
-- Dependencies: 175
-- Name: ES_USERS_ROLES_USER_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('"ES_USERS_ROLES_USER_ID_seq"', 1, false);


--
-- TOC entry 1974 (class 0 OID 16462)
-- Dependencies: 171
-- Data for Name: ROLE; Type: TABLE DATA; Schema: public; Owner: estiauser
--

COPY "ROLE" (id, type) FROM stdin;
1	Admin
2	Seller
3	Visitor
4	Buyer
5	Lessor
6	Tenant
\.


--
-- TOC entry 1973 (class 0 OID 16459)
-- Dependencies: 170
-- Data for Name: USER; Type: TABLE DATA; Schema: public; Owner: estiauser
--

COPY "USER" (id, username, firstname, lastname, email, telephone, password, type) FROM stdin;
\.


--
-- TOC entry 1975 (class 0 OID 16465)
-- Dependencies: 172
-- Data for Name: USERROLE; Type: TABLE DATA; Schema: public; Owner: estiauser
--

COPY "USERROLE" ("userId", "roleId") FROM stdin;
\.


--
-- TOC entry 1981 (class 0 OID 16519)
-- Dependencies: 178
-- Data for Name: USERTYPE; Type: TABLE DATA; Schema: public; Owner: estiauser
--

COPY "USERTYPE" (id, type) FROM stdin;
1	Pending
2	Active
900	Deleted
\.


--
-- TOC entry 2001 (class 0 OID 0)
-- Dependencies: 177
-- Name: USERTYPE_id_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('"USERTYPE_id_seq"', 1, false);


--
-- TOC entry 2002 (class 0 OID 0)
-- Dependencies: 179
-- Name: USER_type_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('"USER_type_seq"', 1, false);


--
-- TOC entry 1862 (class 2606 OID 16538)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY "USERTYPE"
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1858 (class 2606 OID 16487)
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY "ROLE"
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 1856 (class 2606 OID 16489)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY "USER"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 1859 (class 1259 OID 16516)
-- Name: fki_ROLE_ID; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX "fki_ROLE_ID" ON "USERROLE" USING btree ("roleId");


--
-- TOC entry 1860 (class 1259 OID 16510)
-- Name: fki_USER_ID; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX "fki_USER_ID" ON "USERROLE" USING btree ("userId");


--
-- TOC entry 1854 (class 1259 OID 16544)
-- Name: fki_type; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX fki_type ON "USER" USING btree (type);


--
-- TOC entry 1864 (class 2606 OID 16511)
-- Name: roleId; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USERROLE"
    ADD CONSTRAINT "roleId" FOREIGN KEY ("roleId") REFERENCES "ROLE"(id);


--
-- TOC entry 1863 (class 2606 OID 16539)
-- Name: type; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USER"
    ADD CONSTRAINT type FOREIGN KEY (type) REFERENCES "USERTYPE"(id);


--
-- TOC entry 1865 (class 2606 OID 16505)
-- Name: userId; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY "USERROLE"
    ADD CONSTRAINT "userId" FOREIGN KEY ("userId") REFERENCES "USER"(id);


--
-- TOC entry 1989 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-06-17 14:34:12

--
-- PostgreSQL database dump complete
--

