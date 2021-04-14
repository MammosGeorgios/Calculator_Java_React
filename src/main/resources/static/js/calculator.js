
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
    }else if(action==="="){
        // MUST UPDATE ONCE BACKEND IS READY
        console.log("Equals has been pressed! \n The math expression is:\n'" + $("#calculatorDisplay").html() +" = ?'");
        setDisplay("0");
    }else{
        addOperatorToDisplay(action);
    }
}

function addOperatorToDisplay(operator){
    // NEED TO CHECK IF THERE IS ALREADY AN OPERATOR IN THE END
    // SINCE OPERATORS ARE ADDED WITH SPACE BEFORE AND AFTER I JUST NEED TO CHECK IF THE SECOND TO LAST CHAR IS AN OPERATOR
    // the check of at least 3 is because the minimum i can have is an expresion like '0 + '. It will be impossible to have an operator in just the first 3 chars
    // in any other scenario i just add the operator at the end with spaces on both sides

    let currentDisplay = $("#calculatorDisplay").html();
    if(currentDisplay.length>3){
        let secondLastChar = currentDisplay[currentDisplay.length - 2];
        if(checkIfOperator(secondLastChar)===true){
            // In this case i want to correct the display
            currentDisplay = currentDisplay.substring(0, currentDisplay.length-2) + operator + " ";
        }else{
            currentDisplay = currentDisplay + " " + operator + " ";
        }
    }else{
        currentDisplay = currentDisplay + " " + operator + " ";
    }
    setDisplay(currentDisplay);
}

function checkIfOperator(operator){
    return(operator==="*" || operator==="/" || operator==="+" || operator==="-");
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