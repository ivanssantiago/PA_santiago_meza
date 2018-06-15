program error;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
  I : char;
  Count : Integer;

begin
  repeat
  WriteLn('Enter a value: ');
  Read(I);
  If(I='Q') Then
        runError (255);
  Until FALSE;
  ReadLn
end.
 