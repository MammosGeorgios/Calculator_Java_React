
function setDisplay(text){
    $("#calculatorDisplay").html(text);
}
// a switch function to select appropriate action
function buttonPress(button){
    switch (button) {
        case "clearButton":
            operatorAction("clear");
            break;
        case "divideButton":
            operatorAction("/");
            break;
        case "multiplyButton":
            operatorAction("*");
            break;
        case "subtractButton":
            operatorAction("-");
            break;
        case "addButton":
            operatorAction("+");
            break;
        case "equalsButton":
            operatorAction("=");
            break;
        case "9":
            numberAction("9");
            break;
        case "8":
            numberAction("8");
            break;
        case "7":
            numberAction("7");
            break;
        case "6":
            numberAction("6");
            break;
        case "5":
            numberAction("5");
            break;
        case "4":
            numberAction("4");
            break;
        case "3":
            numberAction("3");
            break;
        case "2":
            numberAction("2");
            break;
        case "1":
            numberAction("1");
            break;
        case "0":
            numberAction("0");
            break;
        case "decimalButton":
            decimalAction();
            break;
        default:
            alert("Unhandled error in action choosing");
            operatorAction("clear");
    }
}


//WILL NEED UPDATE ONCE BACKEND IS READY
function operatorAction(action){
    if (action == "clear"){
        setDisplay("0");
    }else{
        //TEMP
        console.log("Action used: " + action);
    }
}

function numberAction(number){
    numberInputToDisplay(number);
}

function numberInputToDisplay(number){
    let currentDisplay = $("#calculatorDisplay").html();
    if(currentDisplay=="0"){
        setDisplay(number);
    }else{
        setDisplay(currentDisplay+number);
    }
}

function decimalAction(){
    decimalInputToDisplay();
}

function decimalInputToDisplay(){
    let currentDisplay = $("#calculatorDisplay").html();

    //NEED TO CHECK IF DISPLAY ALREADY HAS A DECIMAL POINTER
    let hasPointer = currentDisplay.includes(".");
    if(hasPointer == false){
        setDisplay(currentDisplay +".");
    }
}