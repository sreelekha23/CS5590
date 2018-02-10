var input1 = prompt("choose wither rock paper or scissors");
var input2 = Math.random();
if(input2 < 0.35)
{
    input2="rock";

}else if(input2<=0.70){
    input2="paper";
}else {
    input2 = "scissors";
}
 var compare =function(a,b){
    if(a==b)
    {
        return "tie";
    }
    if(a=="rock"){
        if(b=="scissors"){
            return "rock wins"
        }
        else{return "paper wins";
        }

    }
    if(a=="paper"){
        if(b=="rock"){
            return "paper wins";
        }
        else{
            return "scissors wins";
        }
    }
    if(a=="scissors"){
        if(b=="rock"){
            return "rock wins";
        }
        else{
            return "scissors wins";
        }
    }
}
console.log(compare(input1,input2));
var s = compare(input1,input2);
alert(s);
