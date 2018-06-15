

char caracter;
String comando;

void setup(){
  pinMode(8, OUTPUT); // Pin 8 la configuramos como salida.
  pinMode(13, OUTPUT); 
  Serial.begin(115200); // Baudios a 115200.
}

void loop()
{
  /* Se lee carácter por carácter por el puerto serie, mientras, se va
  concatenando uno tras otro en una cadena. */
  while (Serial.available()>0)
    {
      caracter= Serial.read();
      comando.concat(caracter);
      delay(10); // Este retardo muy corto es para no saturar el puerto
                 // serie y que la concatenación se haga de forma ordenada.
    }
    
  if (comando.equals("Led_8_ON") == true) // Si la cadena o comando "Led_8_ON" es verdadero.
    {
      digitalWrite(8, HIGH); // El Led 8 se enciende.
      Serial.println("Led 8 encendido."); // Envía mensaje por puerto serie.
    } 
    
  if (comando.equals("Led_8_OFF")== true) // Si el comando "Led_8_OFF" es verdadero.
    {
      digitalWrite(8, LOW); // Se apaga el Led 8.
      Serial.println("Led 8 apagado."); // Envía mensaje por puerto serie.
    }
    
    if (comando.equals("Led_13_ON") == true)
    {
      digitalWrite(13, HIGH);
      Serial.println("Led 13 encendido.");
    }
    
    if (comando.equals("Led_13_OFF")== true)
    {
      digitalWrite(13, LOW);
      Serial.println("Led 13 apagado.");
    }
    
    // Limpiamos la cadena para volver a recibir el siguiente comando.
  comando="";
}
