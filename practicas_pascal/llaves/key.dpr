program key;

{$APPTYPE CONSOLE}

uses
  SysUtils;

type
 KeysValues =1..9;
 CharValues='a'..'z';
 KeysType = set of KeysValues;
 CharKey = set of CharValues;

 var
      Keys : KeysType;
      APossibleUserInput :KeysType;
      APosibChKey : CharKey;
      UserInput : Char;

begin

  APossibleUserInput := [];
  If 1 in APossibleUserInput then
   WriteLn('That value was OK');
  Keys := [2,4,6];
  If 0 in Keys then
   WriteLn('0 is in Keys');

  If 2 in Keys then
   WriteLn('That Value was OK_1');

   APosibChKey := ['a','e','i','o','u'];
   UserInput :='a';
   if UserInput in APosibChKey then
   WriteLn('That value is OK_2');

   ReadLn;
  { TODO -oUser -cConsole Main : Insert code here }
end.
