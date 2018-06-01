/*main.cpp primer programa
	*@author: 2MV4
	*@version: 2018.02.09
	*muestra declaración de seccioes privadas
	*y la instansación de objetos de las clases declaradas.
	*/
	
#include <iostream>
using namespace std;
//class oración
struct oracion{
	string sujeto;
	string predicado;
	bool esHyperbaton;
	/*
		Una oración proporciona un mensaje completo. 						
	*/
	void mensaje(){
		if(!esHyperbaton)
			cout<<sujeto<<" "<<predicado<<endl;
		else
			cout<<predicado<<" "<<sujeto<<endl;
	}
	 bool operator==(oracion);
	 oracion* operator+(oracion);
};//end class oración
int main() {
	oracion oracion1;
	oracion1.sujeto="Chaplin";
	oracion1.predicado="fue actor";
	oracion1.esHyperbaton=false;
	oracion1.mensaje();
//	oracion1.esHyperbaton=true;
//	oracion1.mensaje();
	oracion oracion2;
	oracion2.sujeto=oracion1.predicado;
	oracion2.predicado=oracion1.sujeto;
	oracion1.esHyperbaton=false;
	oracion2.mensaje();
	if (!(oracion1==oracion2)){
		cout<<"no ";
	}
	cout<<"son iguales"<<endl;
	oracion *oraci=oracion1+oracion2;
	(*oraci).mensaje();
	return 0;
}
bool oracion::operator==(oracion ora){
	bool R=false;
	if((sujeto==ora.sujeto)&&(predicado==ora.predicado))
		R=true;
	else
		return R;
}
oracion* oracion::operator+(oracion ora){
	oracion* R=new oracion();
	R->sujeto=sujeto+" "+predicado;
	R->predicado=predicado+" "+ora.predicado;
	return R;
}
