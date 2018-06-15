program Project2;

{$APPTYPE CONSOLE}

uses
  SysUtils;

type
   StopLigthColors = (Red, Yellow, Green);
  var
   Myligth : StopLigthColors;

begin
 MyLigth := Red;
 WriteLn('My ligth is currently',#9,Integer(MyLigth),#13#10);
 MyLigth := Green;
 WriteLn('My new ligth is currently',#9,Integer(MyLigth));
 ReadLn

  { TODO -oUser -cConsole Main : Insert code here }
end.
 