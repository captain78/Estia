
COPY Message (id, userId, propertyId, read, message) FROM stdin;
\.

COPY PropertyStatus (propertyId, propertyStatus) FROM stdin;
\.

COPY Property (id, userId, type) FROM stdin;
\.

COPY PropertyStatusCodes (id, status) FROM stdin;
1	Rent
2	Sale
\.


COPY PropertyTypeCodes (id, type) FROM stdin;
1	House
2	Apartment
\.


COPY RoleCodes (id, type) FROM stdin;
1	Admin
2	Seller
3	Visitor
4	Buyer
5	Lessor
6	Tenant
\.


COPY SortingAlgorithmsCodes (id, description) FROM stdin;
1	SAW
2	TOPSIS
\.

COPY Users (id, username, firstname, lastname, email, telephone, password, type) FROM stdin;
1	estiauser	estiauser	estiauser	estiauser@estiauser.estiauser	0123456789	estiapwd	100
\.

COPY UserRole (userId, roleId) FROM stdin;
1	1
\.


COPY UserTypeCodes (id, type) FROM stdin;
1	Pending
900	Deleted
100	Active
\.

