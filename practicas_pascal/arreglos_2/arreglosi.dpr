program arreglosi;

{$APPTYPE CONSOLE}

uses
  SysUtils;

type
  PersonRecordType = Record
  name : string [30];
  PhoneNumber : String[15];
  Age : Integer;
  Sex : Char;
  end;

  MyArrayType = Array [1..3] of PersonRecordType;

  var
  PersonArray : MyArrayType;

begin
PersonArray[1].name:='Dan Osier';
PersonArray[1].PhoneNumber:='(916)555-1212';
PersonArray[1].Age:=33;
PersonArray[1].Sex:='M';

PersonArray[2].name:='Susie Smith';
PersonArray[2].PhoneNumber:='(916)555-9999';
PersonArray[2].Age:=32;
PersonArray[2].Sex:='F';

PersonArray[3].name:='Pat';
PersonArray[3].PhoneNumber:='(916)555-7766';
PersonArray[3].Age:=30;
PersonArray[3].Sex:='?';

WriteLn('The person 1 name is ',PersonArray[1].name);
WriteLn('The person 1 phone number is ',PersonArray[1].PhoneNumber);
WriteLn('The person 1 age is ',PersonArray[1].Age);
WriteLn('The person 1 sex is ',PersonArray[1].Sex,#13#10);

WriteLn('The person 2 name is ',PersonArray[2].name);
WriteLn('The person 2 phone number is ',PersonArray[2].PhoneNumber);
WriteLn('The person 2 age is ',PersonArray[2].Age);
WriteLn('The person 2 sex is ',PersonArray[2].Sex,#13#10);

WriteLn('The person 3 name is ',PersonArray[3].name);
WriteLn('The person 3 phone number is ',PersonArray[3].PhoneNumber);
WriteLn('The person 3 age is ',PersonArray[3].Age);
WriteLn('The person 3 sex is ',PersonArray[3].Sex,#13#10);

ReadLn;
  { TODO -oUser -cConsole Main : Insert code here }
end.
