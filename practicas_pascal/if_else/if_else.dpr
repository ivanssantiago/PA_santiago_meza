program if_else;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
   UserInput : Integer;

begin
 Write('¿How old you are?');
 ReadLn(UserInput);
 if (UserInput < 1) or (UserInput > 130) then
  WriteLn('You are not telling the truth.')
 else
  WriteLn('Being ',UserInput,' years old is great!');
  ReadLn
  { TODO -oUser -cConsole Main : Insert code here }
end.
 