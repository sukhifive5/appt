<div ng-controller="dayView">
  <div class="dayRow">
      <div class="Column header">Staff Name</div>  
      <div ng-repeat="x in dayHours" class="Column" ngClass="hours {{x}}" id="{{x}}">
        	<div class="odd">{{x}}</div ><div class="even">&nbsp; </div><div class="odd"> &nbsp;</div><div class="even">&nbsp;</div>
       </div>
       
    </div> 
    <div class="dayRow" ng-repeat="x in employees">
      <div class="Column header">{{x}}</div>  
      <div ng-repeat="h in dayHours" class="Column" ngClass="hours {{h}}" id="{{h}}">
        	<div class="odd" id="{{x}} {{h}}:00">&nbsp;</div ><div id="{{x}} {{h}}:15" class="even"><span class="box">Event 1</span> </div><div id="{{x}} {{h}}:30" class="odd"> &nbsp;</div><div id="{{x}} {{h}}:45" class="even">&nbsp;</div>
       </div>
       
    </div>   
</div>


<style>
.box {
    opacity: 0.9;
    padding-top: 10px;
    position: absolute; 
    background: red;
    padding: 0px;
    border: 1px solid red;
    height: 20px;
    width: 20px;
}


div.header {
	float:left; 
    width:100px;
    height:33px;
    border-color: grey;    
    //border-bottom-style: solid;  
    border-right-style: solid;   
    border-width: 1px;
}

.dayRow{
	display: table;
    width: 100%; /*Optional*/  
    white-space:nowrap;
    border-color: grey;    
    border-style: solid;    
    border-width: 1px;
}
.Column
{
    float:left; 
    width:auto;
    

}
.even, .odd
{
    width:25px;
    float:left;
    height:33px;
    display: inline-block;
  //  background-color: yellow;
}
.even
{
    border-color: grey;    
    border-right-style: solid;    
    border-width: 1px;
}
.odd
{
    border-right-style: dashed;
    
    border-width: 1px;
}
</style>