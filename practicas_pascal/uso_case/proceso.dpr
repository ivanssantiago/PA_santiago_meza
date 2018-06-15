program proceso;

{$APPTYPE CONSOLE}

uses
  SysUtils;

procedure DoVerticals;
  begin
  WriteLn('  |  |  ');
  end;

  procedure DoHorizontal;
  begin
        WriteLn('---------');
  end;

begin
  DoVerticals;
  DoHorizontal;
  DoVerticals;
  DoHorizontal;
  DoVerticals;
  ReadLn
end.
 