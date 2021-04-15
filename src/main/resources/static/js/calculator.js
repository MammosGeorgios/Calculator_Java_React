
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
        equalsAction();

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

function equalsAction(){
    /*
    We need to check
    1) if there is an operator at the end without a number to follow it
    2) there is at least one operator
    Checking if there are operands is easy because we just need to check for spaces. every operator gets added with space on both sides
     */
    let currentDisplay = $("#calculatorDisplay").html();
    let validExpression = false;
    // console.log("Equals has been pressed! \n The math expression is:\n'" + $("#calculatorDisplay").html() +"'"); // FOR TESTING - REMOVE AFTER

    if(currentDisplay[currentDisplay.length-1]==" "){
        // this means we are ending with an operator without a number following it
        // i will remove the last operator
        currentDisplay = currentDisplay.substring(0, currentDisplay.length-4) ; // i remove the last 3 chars (-4 because of zero index)
    }
    if(!currentDisplay.includes(" ")) {
        // if current display has zero spaces, it means that we have ZERO OPERATORS - remember each operators gets added with spaces on both sides
        alert("Invalid Expression\nPlease update.");
    }else{
        validExpression=true;
    }
    if(validExpression===true){
        console.log("Final expression is:\n'" + currentDisplay+ "'");
        //setDisplay("0"); //resetting for easier testing, later on we will have better functionality here


        $.get( "http://localhost:8080/operation/'" + currentDisplay + "'", function( data ) {
            $("#calculatorDisplay").html( data );
        });


    }
}

function containsSpace(string){
    return string.includes(" ");
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
    //NEED TO CHECK IF DISPLAY ALREADY HAS A DECIMAL POINTER AT THE END
    let hasPointer = currentDisplay.charAt(currentDisplay.length-1)==".";
    if(hasPointer == false){
        setDisplay(currentDisplay +".");
    }
}