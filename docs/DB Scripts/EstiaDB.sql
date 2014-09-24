--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-09-24 17:42:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 260 (class 1259 OID 20933)
-- Name: dhmosia_kthria; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE dhmosia_kthria (
    id integer NOT NULL,
    geom geometry(MultiPoint,3857),
    a_a_1 double precision,
    tetrapsifi double precision,
    ktirio_ypi character varying(254),
    perifereia character varying(56),
    nomos_1 character varying(32),
    megethos_1 character varying(14),
    typos_1 character varying(176),
    diefthinsi character varying(204),
    arithmos character varying(35),
    tk_1 character varying(10),
    dimos_1 character varying(54),
    lat numeric,
    lng numeric
);


ALTER TABLE public.dhmosia_kthria OWNER TO estiauser;

--
-- TOC entry 259 (class 1259 OID 20931)
-- Name: dhmosia_kthria_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE dhmosia_kthria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dhmosia_kthria_id_seq OWNER TO estiauser;

--
-- TOC entry 3704 (class 0 OID 0)
-- Dependencies: 259
-- Name: dhmosia_kthria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE dhmosia_kthria_id_seq OWNED BY dhmosia_kthria.id;


--
-- TOC entry 262 (class 1259 OID 20950)
-- Name: ethnika_parka; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE ethnika_parka (
    id_0 integer NOT NULL,
    geom geometry(MultiPolygon,3857),
    objectid integer,
    id integer,
    kode character varying(7),
    name character varying(94),
    fek character varying(62),
    updated character varying(10),
    zone character varying(176),
    area_ numeric,
    perimeter numeric,
    hectares numeric,
    shape_area numeric,
    shape_len numeric
);


ALTER TABLE public.ethnika_parka OWNER TO estiauser;

--
-- TOC entry 261 (class 1259 OID 20948)
-- Name: ethnika_parka_id_0_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE ethnika_parka_id_0_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ethnika_parka_id_0_seq OWNER TO estiauser;

--
-- TOC entry 3705 (class 0 OID 0)
-- Dependencies: 261
-- Name: ethnika_parka_id_0_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE ethnika_parka_id_0_seq OWNED BY ethnika_parka.id_0;


--
-- TOC entry 267 (class 1259 OID 26574)
-- Name: message; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE message (
    id integer NOT NULL,
    userid integer,
    propertyid integer,
    read boolean,
    message text NOT NULL
);


ALTER TABLE public.message OWNER TO estiauser;

--
-- TOC entry 268 (class 1259 OID 26580)
-- Name: message_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.message_id_seq OWNER TO estiauser;

--
-- TOC entry 3706 (class 0 OID 0)
-- Dependencies: 268
-- Name: message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE message_id_seq OWNED BY message.id;


--
-- TOC entry 258 (class 1259 OID 20901)
-- Name: oikismoi; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE oikismoi (
    id integer NOT NULL,
    geom geometry(MultiPoint,3857),
    objectid double precision,
    code_oik character varying(8),
    name_oik character varying(98),
    code_gdiam character varying(1),
    namef_oik character varying(100),
    point_x numeric,
    point_y numeric,
    lat numeric,
    lon numeric,
    h double precision,
    edra_diam double precision,
    code_diam character varying(8),
    name_diam character varying(100),
    code_ota character varying(8),
    name_ota character varying(50),
    code_nom character varying(2),
    name_nom character varying(50),
    name_gdiam character varying(50)
);


ALTER TABLE public.oikismoi OWNER TO estiauser;

--
-- TOC entry 257 (class 1259 OID 20899)
-- Name: oikismoi_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE oikismoi_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.oikismoi_id_seq OWNER TO estiauser;

--
-- TOC entry 3707 (class 0 OID 0)
-- Dependencies: 257
-- Name: oikismoi_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE oikismoi_id_seq OWNED BY oikismoi.id;


--
-- TOC entry 250 (class 1259 OID 19902)
-- Name: oria_dhmwn_kallikraths; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE oria_dhmwn_kallikraths (
    id integer NOT NULL,
    geom geometry(MultiPolygon,3857),
    name character varying(59),
    kwd_ypes character varying(4)
);


ALTER TABLE public.oria_dhmwn_kallikraths OWNER TO estiauser;

--
-- TOC entry 249 (class 1259 OID 19900)
-- Name: oria_dhmwn_kallikraths_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE oria_dhmwn_kallikraths_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.oria_dhmwn_kallikraths_id_seq OWNER TO estiauser;

--
-- TOC entry 3708 (class 0 OID 0)
-- Dependencies: 249
-- Name: oria_dhmwn_kallikraths_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE oria_dhmwn_kallikraths_id_seq OWNED BY oria_dhmwn_kallikraths.id;


--
-- TOC entry 252 (class 1259 OID 20264)
-- Name: oria_diamerismatwn; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE oria_diamerismatwn (
    id integer NOT NULL,
    geom geometry(MultiLineString,3857),
    objectid integer,
    shape_leng numeric
);


ALTER TABLE public.oria_diamerismatwn OWNER TO estiauser;

--
-- TOC entry 251 (class 1259 OID 20262)
-- Name: oria_diamerismatwn_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE oria_diamerismatwn_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.oria_diamerismatwn_id_seq OWNER TO estiauser;

--
-- TOC entry 3709 (class 0 OID 0)
-- Dependencies: 251
-- Name: oria_diamerismatwn_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE oria_diamerismatwn_id_seq OWNED BY oria_diamerismatwn.id;


--
-- TOC entry 256 (class 1259 OID 20653)
-- Name: oria_nomwn; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE oria_nomwn (
    id integer NOT NULL,
    geom geometry(MultiLineString,3857),
    shape_leng numeric,
    type_land integer
);


ALTER TABLE public.oria_nomwn OWNER TO estiauser;

--
-- TOC entry 255 (class 1259 OID 20651)
-- Name: oria_nomwn_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE oria_nomwn_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.oria_nomwn_id_seq OWNER TO estiauser;

--
-- TOC entry 3710 (class 0 OID 0)
-- Dependencies: 255
-- Name: oria_nomwn_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE oria_nomwn_id_seq OWNED BY oria_nomwn.id;


--
-- TOC entry 248 (class 1259 OID 19890)
-- Name: poleis; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE poleis (
    id integer NOT NULL,
    geom geometry(MultiPoint,3857),
    onoma character varying(40),
    name character varying(40)
);


ALTER TABLE public.poleis OWNER TO estiauser;

--
-- TOC entry 247 (class 1259 OID 19888)
-- Name: poleis_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE poleis_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.poleis_id_seq OWNER TO estiauser;

--
-- TOC entry 3711 (class 0 OID 0)
-- Dependencies: 247
-- Name: poleis_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE poleis_id_seq OWNED BY poleis.id;


--
-- TOC entry 270 (class 1259 OID 26585)
-- Name: property; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE property (
    id integer NOT NULL,
    userid integer NOT NULL,
    type integer NOT NULL,
    topothesia geometry(Point,3857),
    dieythinsi character varying(150) NOT NULL,
    price double precision NOT NULL,
    emvadon real NOT NULL,
    constructionyear integer NOT NULL,
    renovationyear integer NOT NULL,
    centralheating boolean NOT NULL,
    koinoxrista double precision,
    orofos integer NOT NULL
);


ALTER TABLE public.property OWNER TO estiauser;

--
-- TOC entry 275 (class 1259 OID 26604)
-- Name: property_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE property_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.property_id_seq OWNER TO estiauser;

--
-- TOC entry 3712 (class 0 OID 0)
-- Dependencies: 275
-- Name: property_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE property_id_seq OWNED BY property.id;


--
-- TOC entry 284 (class 1259 OID 34760)
-- Name: propertyimages; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE propertyimages (
    id integer NOT NULL,
    property_id integer NOT NULL,
    image_path character varying(150) NOT NULL
);


ALTER TABLE public.propertyimages OWNER TO estiauser;

--
-- TOC entry 283 (class 1259 OID 34758)
-- Name: propertyimages_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE propertyimages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.propertyimages_id_seq OWNER TO estiauser;

--
-- TOC entry 3713 (class 0 OID 0)
-- Dependencies: 283
-- Name: propertyimages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE propertyimages_id_seq OWNED BY propertyimages.id;


--
-- TOC entry 269 (class 1259 OID 26582)
-- Name: propertystatus; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE propertystatus (
    propertyid integer NOT NULL,
    propertystatus integer NOT NULL
);


ALTER TABLE public.propertystatus OWNER TO estiauser;

--
-- TOC entry 271 (class 1259 OID 26588)
-- Name: propertystatuscodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE propertystatuscodes (
    id integer NOT NULL,
    status text NOT NULL
);


ALTER TABLE public.propertystatuscodes OWNER TO estiauser;

--
-- TOC entry 272 (class 1259 OID 26594)
-- Name: propertystatus_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE propertystatus_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.propertystatus_id_seq OWNER TO estiauser;

--
-- TOC entry 3714 (class 0 OID 0)
-- Dependencies: 272
-- Name: propertystatus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE propertystatus_id_seq OWNED BY propertystatuscodes.id;


--
-- TOC entry 273 (class 1259 OID 26596)
-- Name: propertytypecodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE propertytypecodes (
    id integer NOT NULL,
    type text,
    onoma text
);


ALTER TABLE public.propertytypecodes OWNER TO estiauser;

--
-- TOC entry 274 (class 1259 OID 26602)
-- Name: propertytype_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE propertytype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.propertytype_id_seq OWNER TO estiauser;

--
-- TOC entry 3715 (class 0 OID 0)
-- Dependencies: 274
-- Name: propertytype_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE propertytype_id_seq OWNED BY propertytypecodes.id;


--
-- TOC entry 263 (class 1259 OID 26558)
-- Name: rolecodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE rolecodes (
    id integer NOT NULL,
    type text NOT NULL
);


ALTER TABLE public.rolecodes OWNER TO estiauser;

--
-- TOC entry 264 (class 1259 OID 26564)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO estiauser;

--
-- TOC entry 3716 (class 0 OID 0)
-- Dependencies: 264
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE roles_id_seq OWNED BY rolecodes.id;


--
-- TOC entry 276 (class 1259 OID 26606)
-- Name: sortingalgorithmscodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE sortingalgorithmscodes (
    id integer NOT NULL,
    description text NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.sortingalgorithmscodes OWNER TO estiauser;

--
-- TOC entry 280 (class 1259 OID 26623)
-- Name: sortingalgorithms_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE sortingalgorithms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sortingalgorithms_id_seq OWNER TO estiauser;

--
-- TOC entry 3717 (class 0 OID 0)
-- Dependencies: 280
-- Name: sortingalgorithms_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE sortingalgorithms_id_seq OWNED BY sortingalgorithmscodes.id;


--
-- TOC entry 254 (class 1259 OID 20639)
-- Name: sxoleia; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE sxoleia (
    id integer NOT NULL,
    geom geometry(Point,3857),
    onoma character varying
);


ALTER TABLE public.sxoleia OWNER TO estiauser;

--
-- TOC entry 253 (class 1259 OID 20637)
-- Name: sxoleia_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE sxoleia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sxoleia_id_seq OWNER TO estiauser;

--
-- TOC entry 3718 (class 0 OID 0)
-- Dependencies: 253
-- Name: sxoleia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE sxoleia_id_seq OWNED BY sxoleia.id;


--
-- TOC entry 279 (class 1259 OID 26620)
-- Name: userrole; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE userrole (
    userid integer NOT NULL,
    roleid integer NOT NULL
);


ALTER TABLE public.userrole OWNER TO estiauser;

--
-- TOC entry 265 (class 1259 OID 26566)
-- Name: users; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    username text NOT NULL,
    firstname text,
    lastname text NOT NULL,
    email text NOT NULL,
    telephone text NOT NULL,
    password text,
    type numeric NOT NULL
);


ALTER TABLE public.users OWNER TO estiauser;

--
-- TOC entry 266 (class 1259 OID 26572)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO estiauser;

--
-- TOC entry 3719 (class 0 OID 0)
-- Dependencies: 266
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 277 (class 1259 OID 26612)
-- Name: usertypecodes; Type: TABLE; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE TABLE usertypecodes (
    id integer NOT NULL,
    type text
);


ALTER TABLE public.usertypecodes OWNER TO estiauser;

--
-- TOC entry 278 (class 1259 OID 26618)
-- Name: usertype_id_seq; Type: SEQUENCE; Schema: public; Owner: estiauser
--

CREATE SEQUENCE usertype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usertype_id_seq OWNER TO estiauser;

--
-- TOC entry 3720 (class 0 OID 0)
-- Dependencies: 278
-- Name: usertype_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: estiauser
--

ALTER SEQUENCE usertype_id_seq OWNED BY usertypecodes.id;


--
-- TOC entry 3524 (class 2604 OID 20936)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY dhmosia_kthria ALTER COLUMN id SET DEFAULT nextval('dhmosia_kthria_id_seq'::regclass);


--
-- TOC entry 3525 (class 2604 OID 20953)
-- Name: id_0; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY ethnika_parka ALTER COLUMN id_0 SET DEFAULT nextval('ethnika_parka_id_0_seq'::regclass);


--
-- TOC entry 3523 (class 2604 OID 20904)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY oikismoi ALTER COLUMN id SET DEFAULT nextval('oikismoi_id_seq'::regclass);


--
-- TOC entry 3519 (class 2604 OID 19905)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY oria_dhmwn_kallikraths ALTER COLUMN id SET DEFAULT nextval('oria_dhmwn_kallikraths_id_seq'::regclass);


--
-- TOC entry 3520 (class 2604 OID 20267)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY oria_diamerismatwn ALTER COLUMN id SET DEFAULT nextval('oria_diamerismatwn_id_seq'::regclass);


--
-- TOC entry 3522 (class 2604 OID 20656)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY oria_nomwn ALTER COLUMN id SET DEFAULT nextval('oria_nomwn_id_seq'::regclass);


--
-- TOC entry 3518 (class 2604 OID 19893)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY poleis ALTER COLUMN id SET DEFAULT nextval('poleis_id_seq'::regclass);


--
-- TOC entry 3526 (class 2604 OID 34754)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY property ALTER COLUMN id SET DEFAULT nextval('property_id_seq'::regclass);


--
-- TOC entry 3527 (class 2604 OID 34763)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY propertyimages ALTER COLUMN id SET DEFAULT nextval('propertyimages_id_seq'::regclass);


--
-- TOC entry 3521 (class 2604 OID 20642)
-- Name: id; Type: DEFAULT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY sxoleia ALTER COLUMN id SET DEFAULT nextval('sxoleia_id_seq'::regclass);


--
-- TOC entry 3547 (class 2606 OID 20938)
-- Name: dhmosia_kthria_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY dhmosia_kthria
    ADD CONSTRAINT dhmosia_kthria_pkey PRIMARY KEY (id);


--
-- TOC entry 3550 (class 2606 OID 20955)
-- Name: ethnika_parka_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY ethnika_parka
    ADD CONSTRAINT ethnika_parka_pkey PRIMARY KEY (id_0);


--
-- TOC entry 3566 (class 2606 OID 26630)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY propertytypecodes
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 3570 (class 2606 OID 26632)
-- Name: id_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY usertypecodes
    ADD CONSTRAINT id_pkey PRIMARY KEY (id);


--
-- TOC entry 3564 (class 2606 OID 26634)
-- Name: key; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY propertystatuscodes
    ADD CONSTRAINT key PRIMARY KEY (id);


--
-- TOC entry 3557 (class 2606 OID 26626)
-- Name: message_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY message
    ADD CONSTRAINT message_pkey PRIMARY KEY (id);


--
-- TOC entry 3544 (class 2606 OID 20906)
-- Name: oikismoi_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY oikismoi
    ADD CONSTRAINT oikismoi_pkey PRIMARY KEY (id);


--
-- TOC entry 3532 (class 2606 OID 19907)
-- Name: oria_dhmwn_kallikraths_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY oria_dhmwn_kallikraths
    ADD CONSTRAINT oria_dhmwn_kallikraths_pkey PRIMARY KEY (id);


--
-- TOC entry 3535 (class 2606 OID 20269)
-- Name: oria_diamerismatwn_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY oria_diamerismatwn
    ADD CONSTRAINT oria_diamerismatwn_pkey PRIMARY KEY (id);


--
-- TOC entry 3541 (class 2606 OID 20658)
-- Name: oria_nomwn_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY oria_nomwn
    ADD CONSTRAINT oria_nomwn_pkey PRIMARY KEY (id);


--
-- TOC entry 3529 (class 2606 OID 19895)
-- Name: poleis_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY poleis
    ADD CONSTRAINT poleis_pkey PRIMARY KEY (id);


--
-- TOC entry 3561 (class 2606 OID 26636)
-- Name: propertid; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY property
    ADD CONSTRAINT propertid PRIMARY KEY (id);


--
-- TOC entry 3576 (class 2606 OID 34765)
-- Name: propertyimages_pk; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY propertyimages
    ADD CONSTRAINT propertyimages_pk PRIMARY KEY (id);


--
-- TOC entry 3559 (class 2606 OID 26628)
-- Name: propertystatus_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY propertystatus
    ADD CONSTRAINT propertystatus_pkey PRIMARY KEY (propertyid, propertystatus);


--
-- TOC entry 3553 (class 2606 OID 26638)
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY rolecodes
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 3568 (class 2606 OID 26640)
-- Name: sortingalgorithm; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY sortingalgorithmscodes
    ADD CONSTRAINT sortingalgorithm PRIMARY KEY (id);


--
-- TOC entry 3539 (class 2606 OID 20644)
-- Name: sxoleia_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY sxoleia
    ADD CONSTRAINT sxoleia_pkey PRIMARY KEY (id);


--
-- TOC entry 3555 (class 2606 OID 26642)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 3574 (class 2606 OID 26644)
-- Name: userrole_pkey; Type: CONSTRAINT; Schema: public; Owner: estiauser; Tablespace: 
--

ALTER TABLE ONLY userrole
    ADD CONSTRAINT userrole_pkey PRIMARY KEY (userid, roleid);


--
-- TOC entry 3571 (class 1259 OID 26645)
-- Name: fki_role_id; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX fki_role_id ON userrole USING btree (roleid);


--
-- TOC entry 3572 (class 1259 OID 26646)
-- Name: fki_user_id; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX fki_user_id ON userrole USING btree (userid);


--
-- TOC entry 3562 (class 1259 OID 34753)
-- Name: property_topothesia_indx; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX property_topothesia_indx ON property USING gist (topothesia);


--
-- TOC entry 3548 (class 1259 OID 20942)
-- Name: sidx_dhmosia_kthria_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_dhmosia_kthria_geom ON dhmosia_kthria USING gist (geom);


--
-- TOC entry 3551 (class 1259 OID 21259)
-- Name: sidx_ethnika_parka_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_ethnika_parka_geom ON ethnika_parka USING gist (geom);


--
-- TOC entry 3545 (class 1259 OID 20910)
-- Name: sidx_oikismoi_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_oikismoi_geom ON oikismoi USING gist (geom);


--
-- TOC entry 3533 (class 1259 OID 20261)
-- Name: sidx_oria_dhmwn_kallikraths_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_oria_dhmwn_kallikraths_geom ON oria_dhmwn_kallikraths USING gist (geom);


--
-- TOC entry 3536 (class 1259 OID 20618)
-- Name: sidx_oria_diamerismatwn_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_oria_diamerismatwn_geom ON oria_diamerismatwn USING gist (geom);


--
-- TOC entry 3542 (class 1259 OID 20897)
-- Name: sidx_oria_nomwn_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_oria_nomwn_geom ON oria_nomwn USING gist (geom);


--
-- TOC entry 3530 (class 1259 OID 19899)
-- Name: sidx_poleis_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_poleis_geom ON poleis USING gist (geom);


--
-- TOC entry 3537 (class 1259 OID 20648)
-- Name: sidx_sxoleia_geom; Type: INDEX; Schema: public; Owner: estiauser; Tablespace: 
--

CREATE INDEX sidx_sxoleia_geom ON sxoleia USING gist (geom);


--
-- TOC entry 3580 (class 2606 OID 26657)
-- Name: foreign2; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY propertystatus
    ADD CONSTRAINT foreign2 FOREIGN KEY (propertyid) REFERENCES propertystatuscodes(id);


--
-- TOC entry 3579 (class 2606 OID 26662)
-- Name: foreing1; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY propertystatus
    ADD CONSTRAINT foreing1 FOREIGN KEY (propertyid) REFERENCES property(id);


--
-- TOC entry 3578 (class 2606 OID 26647)
-- Name: message_propertyid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY message
    ADD CONSTRAINT message_propertyid_fkey FOREIGN KEY (propertyid) REFERENCES property(id);


--
-- TOC entry 3577 (class 2606 OID 26652)
-- Name: message_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY message
    ADD CONSTRAINT message_userid_fkey FOREIGN KEY (userid) REFERENCES users(id);


--
-- TOC entry 3585 (class 2606 OID 34766)
-- Name: property_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY propertyimages
    ADD CONSTRAINT property_id_fk FOREIGN KEY (property_id) REFERENCES property(id) ON DELETE CASCADE;


--
-- TOC entry 3584 (class 2606 OID 26667)
-- Name: roleid; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY userrole
    ADD CONSTRAINT roleid FOREIGN KEY (roleid) REFERENCES rolecodes(id);


--
-- TOC entry 3582 (class 2606 OID 26672)
-- Name: type; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY property
    ADD CONSTRAINT type FOREIGN KEY (type) REFERENCES propertytypecodes(id);


--
-- TOC entry 3583 (class 2606 OID 26682)
-- Name: userid; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY userrole
    ADD CONSTRAINT userid FOREIGN KEY (userid) REFERENCES users(id);


--
-- TOC entry 3581 (class 2606 OID 26677)
-- Name: users; Type: FK CONSTRAINT; Schema: public; Owner: estiauser
--

ALTER TABLE ONLY property
    ADD CONSTRAINT users FOREIGN KEY (userid) REFERENCES users(id);


-- Completed on 2014-09-24 17:42:01

--
-- PostgreSQL database dump complete
--

