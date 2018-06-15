#include <iostream>
#include <fstream>
#include <vector>
using namespace std;
#include <stdlib.h>
#include <stdio.h>
#include <windows.h>	/*STARTUPINFO, PROCESS_INFORMATION*/
#include "Pol_Directory.h"
#include "String_Tokenizer.h"
#include "Polinomio.h"

#define MAXSIZE	1000
int last_backslash(TCHAR*);
void get_substr(TCHAR* cmdL,int intCantidad,char charBuf[MAXSIZE]);
#define TEST_SHELL
#ifdef TEST_SHELL
//	#define COMANDO_0
//#ifdef COMANDO_0
//class comando0{

////Prototipos de funciones
//public:
////	comando0();
//void proccess_operation(Pol_Directory&,string&,unsigned char,string&);
//void do_suma(Pol_Directory&,string&,string&);
//void do_save(Pol_Directory&);
//
//
////	cout<<"Dummy HOLA MUNDO desde "<<argv[0]<<"!!!"<<endl;
////	cout<<"Dummy HOLA MUNDO!!!"<<endl;
//
//};
//#endif

int main(){
  //Abrir funci'/on principal, declarar variables y crear el objeto archivo
  

  
  //	comando0 s;
  TCHAR*              cmdline;
  STARTUPINFO         startup_info;
  PROCESS_INFORMATION process_info;

  char charBuffer[MAXSIZE];
  char exepath[MAXSIZE];
  char str[MAXSIZE];

  cmdline = GetCommandLine();	/*obtiene la orden o comando equivalente de CLI*/
  								/*CLI: Command Line Interface*/
//  cout<<"IMPRIMIR cmdline, ... REVISAR"<<endl;/*OK Si se obtiene el comando con*/
                                              /*el que se est\'a ejecutando este*/
                                              /*programa, Ahora, ver para que se usa*/
//  cout<<cmdline<<endl;

  int intCantidad=last_backslash(cmdline);
 // printf("intCantidad=%i\n",intCantidad);
  get_substr(cmdline,intCantidad,charBuffer);
//  printf("charBuffer:\n%s\n",charBuffer);
 // system("PAUSE");
 
   fstream archivo("workspace.txt");
  string var1, var2;
  int op, op2;
  
  do{
  	cout << "Para usar el programa presionar 1 para capturar el polinomio, volver a\npresionar 1 para guardar y ahora presionamos salir y hara la operacion\nNota: Tambien se pueden ver los resultados guradados en el archivo workspace.txt\n";
  	cout << "1. Nuevo registro\n2. Salir\n";
  	cin >> op;
  	cin.ignore();
  	
  	if(op == 1)
  	{
  		if(!archivo.is_open())
  		{
  			archivo.open("workspace.txt", ios::out);
		  }
		  
		  cout << "Variable 1: ";
		  getline(cin, var1);
		  cout << "Variable 2: ";
		  getline(cin, var2);
		  
		  cout << "1. Guardar registro\n2. Regresar\n";
		  cin >> op2;
		  
		  if(op2 == 1)
		  {
		  	archivo << "var1\n" << var1 << endl;
		  	archivo << "var2\n" << var2 << endl;
		  	
		  	system("cls");
		  	
		  	cout << "Registro guardado con exito...\n";
		  	system("pause");
		  	system("cls");
		  }
		  archivo.close();
	  }
  }while(op !=2);
 
  char workspace[]="workspace.txt";
 
  sprintf(exepath,"%s%s",charBuffer,"comando0.exe");
  char dummy[]="dummy";
  sprintf(str,"%s ./%s %s %s %s %s","comando0.exe",
  	  workspace,"var1","+","var2",dummy);
 printf("IMPRIMIR COMANDO A EJECUTAR PASANDO ARGUMENTOS:\n");	
  printf("%s\n",str);
  fill_n( (char*)&process_info, sizeof( PROCESS_INFORMATION ), 0 );
  fill_n( (char*)&startup_info, sizeof( STARTUPINFO ),         0 );
  startup_info.cb = sizeof( STARTUPINFO );
  if (!CreateProcess(
         exepath,
         str,
         NULL,
         NULL,
         TRUE,
         NORMAL_PRIORITY_CLASS,
         NULL,
         NULL,
         &startup_info,
         &process_info
         )){
   	return 2;
  }
 CloseHandle( process_info.hThread );
 // wait for the child program to terminate
  WaitForSingleObject( process_info.hProcess, INFINITE );
  cout<<"TERMINO EL PROCESO QUE USA comando0.exe"<<endl;
  system("PAUSE");

  //Leer el resultado
  string source_name=string(workspace);
  Pol_Directory the_directory;
  the_directory.load_data(source_name);
  //s.proccess_operation(the_directory, var1,'+',var2);
  string coeffs0=the_directory.lookup_entry("ans");
  String_Tokenizer tokenizer0(coeffs0,":");
  vector<string> arr0;
  while(tokenizer0.has_more_tokens()){
    arr0.push_back(tokenizer0.next_token());
  }//end while()
  cout<<"arr0:"<<endl;
  for(int i=0;i<arr0.size();i++){
    cout<<"arr0[i] = "<<arr0[i]<<endl;
  }
  system("PAUSE");
  int num,den;	/*numerador,denominador*/
  Rac *RacPt0=new Rac[arr0.size()];
  string stringIntNum,stringIntDen;
  String_Tokenizer tokenizerForRac;
  for(int i=0;i<arr0.size();i++){
	tokenizerForRac=String_Tokenizer(arr0[i],"/");
		
	stringIntNum=tokenizerForRac.next_token();
	num=atoi(stringIntNum.c_str());
		
	stringIntDen=tokenizerForRac.next_token();
	den=atoi(stringIntDen.c_str());
		
	*(RacPt0+i)=Rac(num,den);
  }
  Polinomio PolResult0(arr0.size()-1,RacPt0);
  cout<<PolResult0<<endl;
  cout<<PolResult0.string_show()<<endl;
  
  system("PAUSE");
  return 0;
}//end main()
#endif

/**
 * Devuelve la cantidad de car\'acteres que hay que usar de cmdL 
 * para incluir hasta el \'ultimo backslash (es decir, desde el 
 * car\'acter 0 hasta el car\'acter que devuelve esta funci\'on)
 */
int last_backslash(TCHAR* cmdL){
	int r=0,i=0,intI=0;
	while('\0'!=cmdL[i]){
		if('\\'==cmdL[i]){
			r++;
		}
		i++;
	}/*Now r is the amount of backslashes*/
	i=0;
	while((intI<r)&&('\0'!=cmdL[i])){
		if('\\'==cmdL[i]){
			intI++;
		}
		i++;
	}
	return i;
}

void get_substr(TCHAR* cmdL,int intCantidad,char charBuf[MAXSIZE]){
	int i=0;
	while(i<intCantidad){
		charBuf[i]=cmdL[i];
		i++;
	}
	charBuf[i]='\0';
}
