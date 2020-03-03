int output = -1;
int max = 100;
int min = -100;
boolean rising = true;

int getOutputValue(int value){
  if (rising){
    if (value < max){
      return (value + 1);
    }else{
      rising = false;
      return (value - 1);
    }
  }else{
    if (value > min){
      return (value - 1);
    }else{
      rising = true;
      return (value + 1);
    }
  }
}

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  output = getOutputValue(output);
  Serial.println(output);
  delay(10);
}
