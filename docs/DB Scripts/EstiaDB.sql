--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-06-18 11:54:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 188 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 188
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16462)
-- Name: RoleCodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE RoleCodes (
    id integer NOT NULL,
    type text NOT NULL
);


ALTER TABLE public.RoleCodes OWNER TO estiauser;

--
-- TOC entry 173 (class 1259 OID 16468)
-- Name: ES_ROLES_ID_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE ES_ROLES_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ES_ROLES_ID_seq OWNER TO estiauser;

--
-- TOC entry 2051 (class 0 OID 0)
-- Dependencies: 173
-- Name: ES_ROLES_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE ES_ROLES_ID_seq OWNED BY RoleCodes.id;


--
-- TOC entry 170 (class 1259 OID 16459)
-- Name: Users; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE Users (
    id integer NOT NULL,
    username text NOT NULL,
    firstname text,
    lastname text NOT NULL,
    email text NOT NULL,
    telephone text NOT NULL,
    password text,
    type numeric NOT NULL
);


ALTER TABLE public.Users OWNER TO estiauser;

--
-- TOC entry 174 (class 1259 OID 16477)
-- Name: ES_USERS_ID_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE ES_USERS_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ES_USERS_ID_seq OWNER TO estiauser;

--
-- TOC entry 2052 (class 0 OID 0)
-- Dependencies: 174
-- Name: ES_USERS_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE ES_USERS_ID_seq OWNED BY Users.id;


--
-- TOC entry 187 (class 1259 OID 16656)
-- Name: Message; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE Message (
    id integer NOT NULL,
    userId integer,
    propertyId integer,
    read boolean,
    message text NOT NULL
);


ALTER TABLE public.Message OWNER TO estiauser;

--
-- TOC entry 186 (class 1259 OID 16654)
-- Name: Message_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE Message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.Message_id_seq OWNER TO estiauser;

--
-- TOC entry 2053 (class 0 OID 0)
-- Dependencies: 186
-- Name: Message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE Message_id_seq OWNED BY Message.id;


--
-- TOC entry 185 (class 1259 OID 16639)
-- Name: PropertyStatus; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE PropertyStatus (
    propertyId integer NOT NULL,
    propertyStatus integer NOT NULL
);


ALTER TABLE public.PropertyStatus OWNER TO estiauser;

--
-- TOC entry 184 (class 1259 OID 16610)
-- Name: Property; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE Property (
    id integer NOT NULL,
    userId integer NOT NULL,
    type integer NOT NULL
);


ALTER TABLE public.Property OWNER TO estiauser;

--
-- TOC entry 182 (class 1259 OID 16599)
-- Name: PropertyStatusCodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE PropertyStatusCodes (
    id integer NOT NULL,
    status text NOT NULL
);


ALTER TABLE public.PropertyStatusCodes OWNER TO estiauser;

--
-- TOC entry 181 (class 1259 OID 16597)
-- Name: PropertyStatus_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE PropertyStatus_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.PropertyStatus_id_seq OWNER TO estiauser;

--
-- TOC entry 2054 (class 0 OID 0)
-- Dependencies: 181
-- Name: PropertyStatus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE PropertyStatus_id_seq OWNED BY PropertyStatusCodes.id;


--
-- TOC entry 180 (class 1259 OID 16561)
-- Name: PropertyTypeCodes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE PropertyTypeCodes (
    id integer NOT NULL,
    type text
);


ALTER TABLE public.PropertyTypeCodes OWNER TO estiauser;

--
-- TOC entry 179 (class 1259 OID 16559)
-- Name: PropertyType_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE PropertyType_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.PropertyType_id_seq OWNER TO estiauser;

--
-- TOC entry 2055 (class 0 OID 0)
-- Dependencies: 179
-- Name: PropertyType_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE PropertyType_id_seq OWNED BY PropertyTypeCodes.id;


--
-- TOC entry 183 (class 1259 OID 16608)
-- Name: Property_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE Property_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.Property_id_seq OWNER TO estiauser;

--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 183
-- Name: Property_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE Property_id_seq OWNED BY Property.id;


--
-- TOC entry 178 (class 1259 OID 16550)
-- Name: SortingAlgorithmsCodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE SortingAlgorithmsCodes (
    id integer NOT NULL,
    description text NOT NULL
);


ALTER TABLE public.SortingAlgorithmsCodes OWNER TO estiauser;

--
-- TOC entry 176 (class 1259 OID 16519)
-- Name: UserTypeCodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE UserTypeCodes (
    id integer NOT NULL,
    type text
);


ALTER TABLE public.UserTypeCodes OWNER TO estiauser;

--
-- TOC entry 175 (class 1259 OID 16517)
-- Name: USERTYPE_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE USERTYPE_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.USERTYPE_id_seq OWNER TO estiauser;

--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 175
-- Name: USERTYPE_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE USERTYPE_id_seq OWNED BY UserTypeCodes.id;


--
-- TOC entry 172 (class 1259 OID 16465)
-- Name: UserRole; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE UserRole (
    userId integer NOT NULL,
    roleId integer NOT NULL
);


ALTER TABLE public.UserRole OWNER TO estiauser;

--
-- TOC entry 177 (class 1259 OID 16548)
-- Name: sortingAlgorithms_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE sortingAlgorithms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sortingAlgorithms_id_seq OWNER TO estiauser;

--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 177
-- Name: sortingAlgorithms_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE sortingAlgorithms_id_seq OWNED BY SortingAlgorithmsCodes.id;

--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 173
-- Name: ES_ROLES_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('ES_ROLES_ID_seq', 6, true);


--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 174
-- Name: ES_USERS_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('ES_USERS_ID_seq', 1, true);

--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 186
-- Name: Message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('Message_id_seq', 1, false);


SELECT pg_catalog.setval('PropertyStatus_id_seq', 2, true);

SELECT pg_catalog.setval('PropertyType_id_seq', 2, true);


--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 183
-- Name: Property_id_seq; Type: SEQUENCE SET; Schema: public; Owner: estiauser
--

SELECT pg_catalog.setval('Property_id_seq', 1, false);


SELECT pg_catalog.setval('USERTYPE_id_seq', 900, true);


SELECT pg_catalog.setval('sortingAlgorithms_id_seq', 2, true);


ALTER TABLE ONLY Message
    ADD CONSTRAINT Message_pkey PRIMARY KEY (id);


--
-- TOC entry 1907 (class 2606 OID 16643)
-- Name: PropertyStatus_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY PropertyStatus
    ADD CONSTRAINT PropertyStatus_pkey PRIMARY KEY (propertyId, propertyStatus);


--
-- TOC entry 1901 (class 2606 OID 16569)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY PropertyTypeCodes
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1897 (class 2606 OID 16538)
-- Name: id_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY UserTypeCodes
    ADD CONSTRAINT id_pkey PRIMARY KEY (id);


--
-- TOC entry 1903 (class 2606 OID 16607)
-- Name: key; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY PropertyStatusCodes
    ADD CONSTRAINT key PRIMARY KEY (id);


--
-- TOC entry 1905 (class 2606 OID 16628)
-- Name: propertId; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY Property
    ADD CONSTRAINT propertId PRIMARY KEY (id);


--
-- TOC entry 1891 (class 2606 OID 16487)
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY RoleCodes
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 1899 (class 2606 OID 16558)
-- Name: sortingalgorithm; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY SortingAlgorithmsCodes
    ADD CONSTRAINT sortingalgorithm PRIMARY KEY (id);


--
-- TOC entry 1889 (class 2606 OID 16489)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY Users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 1895 (class 2606 OID 16546)
-- Name: userrole; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY UserRole
    ADD CONSTRAINT userrole_pkey PRIMARY KEY (userId, roleId);


--
-- TOC entry 1892 (class 1259 OID 16516)
-- Name: fki_ROLE_ID; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX fki_ROLE_ID ON UserRole USING btree (roleId);


--
-- TOC entry 1893 (class 1259 OID 16510)
-- Name: fki_USER_ID; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX fki_USER_ID ON UserRole USING btree (userId);


--
-- TOC entry 1916 (class 2606 OID 16662)
-- Name: Message_propertyId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY Message
    ADD CONSTRAINT Message_propertyId_fkey FOREIGN KEY (propertyId) REFERENCES Property(id);


--
-- TOC entry 1917 (class 2606 OID 16667)
-- Name: Message_userId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY Message
    ADD CONSTRAINT Message_userId_fkey FOREIGN KEY (userId) REFERENCES Users(id);


--
-- TOC entry 1915 (class 2606 OID 16649)
-- Name: foreign2; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY PropertyStatus
    ADD CONSTRAINT foreign2 FOREIGN KEY (propertyId) REFERENCES PropertyStatusCodes(id);


--
-- TOC entry 1914 (class 2606 OID 16644)
-- Name: foreing1; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY PropertyStatus
    ADD CONSTRAINT foreing1 FOREIGN KEY (propertyId) REFERENCES Property(id);


--
-- TOC entry 1910 (class 2606 OID 16511)
-- Name: roleId; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY UserRole
    ADD CONSTRAINT roleId FOREIGN KEY (roleId) REFERENCES RoleCodes(id);


--
-- TOC entry 1913 (class 2606 OID 16634)
-- Name: type; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY Property
    ADD CONSTRAINT type FOREIGN KEY (type) REFERENCES PropertyTypeCodes(id);


--
-- TOC entry 1912 (class 2606 OID 16629)
-- Name: Users; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY Property
    ADD CONSTRAINT Users FOREIGN KEY (userId) REFERENCES Users(id);


--
-- TOC entry 1911 (class 2606 OID 16505)
-- Name: userId; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY UserRole
    ADD CONSTRAINT userId FOREIGN KEY (userId) REFERENCES Users(id);


--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-06-18 11:54:14

--
-- PostgreSQL database dump complete
--

