*DOMAIN
jeuservice

*NODE
flash    
  WEBTOBDIR = "D:/TmaxSoft/JEUS50019/webserver", 
  SHMKEY    = 54000,
  DOCROOT   = "D:/TmaxSoft/JEUS50019/webserver/docs",
  PORT      = "8080", 
  LOGGING   = "log1",
  ERRORLOG  = "log2",
  JSVPORT   = 9900,
  HTH       = 1

*SVRGROUP
htmlg       NODENAME = "flash", SVRTYPE = HTML
cgig        NODENAME = "flash", SVRTYPE = CGI
ssig        NODENAME = "flash", SVRTYPE = SSI
jsvg        NODENAME = "flash", SVRTYPE = JSV

*SERVER
html        SVGNAME  = htmlg, MinProc = 1,  MaxProc = 2
cgi         SVGNAME  = cgig,  MinProc = 1,  MaxProc = 2
ssi         SVGNAME  = ssig,  MinProc = 1,  MaxProc = 2
MyGroup     SVGNAME  = jsvg,  MinProc = 1, MaxProc = 5

*URI
uri1        Uri      = "/cgi-bin/",  Svrtype = CGI
uri2        Uri      = "/examples/", Svrtype = JSV

*ALIAS
alias1      URI      = "/cgi-bin/", RealPath = "D:/TmaxSoft/JEUS50019/webserver/cgi-bin/"

*LOGGING
log1        Format   = "DEFAULT",   FileName = "D:/TmaxSoft/JEUS50019/webserver/log/access.log", Option = "sync"
log2        Format   = "ERROR",     FileName = "D:/TmaxSoft/JEUS50019/webserver/log/error.log",  Option = "sync"

*EXT
htm         MimeType = "text/html",  SvrType = HTML
jsp   		Mimetype ="application/jsp",  Svrtype=JSV,  SvrName=MyGroup
