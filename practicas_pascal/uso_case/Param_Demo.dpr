program Param_Demo;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
  Number:Integer;

  procedure DoVerticals(HowManyTimes: Integer);
  var Count:Integer;
  begin
        for Count:=1 to HowManyTimes do
         if((Count mod 2)=1) then
                WriteLn('  |  |  ')
         else
                WriteLn('----------');
  end;


begin
repeat
{clrscr;}
  WriteLn('How Many sets of vertical lines would you like to print?: ');
  ReadLn(Number);
  DoVerticals(Number);
  ReadLn
  Until (Number=0)
end.
