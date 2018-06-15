program Project_caseDemo;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
  UserIn : Char;

begin
  WriteLn('Teclee un Char:');
  ReadLn(UserIn);
  Case UserIn of
    'a' .. 'z' : WriteLn('That is a small a');
    {'a'      : WriteLn('That is a small a');   ´}
    'A','Z'  : WriteLn('That is a small or capital Z')
  else
    WriteLn('That is a character other than a, z, or Z.');
  end;
  ReadLn  {evitar cierre de ventana hasta oprimir enter}
end.
