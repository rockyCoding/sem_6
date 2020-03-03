const int buttonPin = 2;     // the number of the pushbutton pin
const int ledPin =  13;      // the number of the LED pin

// variables will change:
int buttonState = 0;
int lastButtonState = 0;
int ledState = 0;


int switchState(int state){
  if (state == HIGH){
    return LOW;
  }else{
    return HIGH;
  }
}

void setup() {
    Serial.begin(9600);
    // initialize the LED pin as an output:
    pinMode(ledPin, OUTPUT);
    // initialize the pushbutton pin as an input:
    pinMode(buttonPin, INPUT);
}

void loop(){
    buttonState = digitalRead(buttonPin);

    if (buttonState == HIGH && lastButtonState == LOW){
      ledState = switchState(ledState);
    }

    if (buttonState == HIGH) {
        // turn LED on:
        digitalWrite(ledPin, HIGH);    
    }
    else {
      if (buttonState = LOW){
        digitalWrite(ledPin, ledState);
      }
    }
    lastButtonState = buttonState;
}
