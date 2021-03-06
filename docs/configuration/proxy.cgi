﻿#!d:/Python34/python.exe


"""This is a blind proxy that we use to get around browser
restrictions that prevent the Javascript from loading pages not on the
same server as the Javascript.  This has several problems: it's less
efficient, it might break some sites, and it's a security risk because
people can use this proxy to browse the web and possibly do bad stuff
with it.  It only loads pages via http and https, but it can load any
content type. It supports GET and POST requests."""

import urllib.request
import string
import cgi
import sys, os

# Designed to prevent Open Proxy type stuff.

allowedHosts = ['www.openlayers.org', 'openlayers.org', 
                'labs.metacarta.com', 'world.freemap.in', 
                'prototype.openmnnd.org', 'geo.openplans.org',
                'sigma.openplans.org', 'demo.opengeo.org',
                'www.openstreetmap.org', 'sample.azavea.com',
                'v2.suite.opengeo.org', 'v-swe.uni-muenster.de:8080', 
                'vmap0.tiles.osgeo.org', 'www.openrouteservice.org',
                'localhost:8090']

method = os.environ["REQUEST_METHOD"]

if method == "POST":
    qs = os.environ["QUERY_STRING"]
    d = cgi.parse_qs(qs)
    if "url" in d:
        url = d["url"][0]
    else:
        url = "http://www.openlayers.org"
else:
    fs = cgi.FieldStorage()
    url = fs.getvalue('url', "http://www.openlayers.org")
try:
    host = url.split("/")[2]
    if allowedHosts and not host in allowedHosts:
        print("Status: 502 Bad Gateway")
        print("Content-Type: text/plain")
        print()
        print("This proxy does not allow you to access that location (%s)." % (host,))
        print()
        print (os.environ)
  
    elif url.startswith("http://") or url.startswith("https://"):
    
        if method == "POST":
            length = int(os.environ["CONTENT_LENGTH"])
            headers = {"Content-Type": os.environ["CONTENT_TYPE"]}
            body = sys.stdin.read(length)
            binary_data = body.encode('utf-8')
            r = urllib.request.Request(url, binary_data, headers)
            y = urllib.request.urlopen(r)
        else:
            y = urllib.request.urlopen(url)
            
        # Get response headers
        i = y.info()
        # Copy all headers
        for k, v in i.items():
            print(k+": "+v)       
        print()
        # avoid utf-8 transformation. write bytes directly
        sys.stdout.flush() # make sure all print() calls are flushed
        sys.stdout.buffer.write(y.read())
        # or
        # print(y.read().decode('utf-8'))
        
        y.close()
    else:
        print("Content-Type: text/plain")
        print()
        print("Illegal request.")

except Exception as E:
    print("Status: 500 Unexpected Error")
    print("Content-Type: text/plain")
    print()
    print("Some unexpected error occurred. Error text was:", E)
