%====================================================================================
% vrsystem description   
%====================================================================================
event( vrinfo, vrinfo(A,B) ).
dispatch( move, move(M) ). %M = w|s|a|d!r!l
%====================================================================================
context(ctxmover, "localhost",  "TCP", "8090").
 qactor( w1, ctxmover, "main.mover").
 static(w1).
  qactor( mover, ctxmover, "it.unibo.mover.Mover").
 static(mover).
