<calendar selected="day">

</calendar>


<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.5/less.min.js"></script>        

<style type="text/less">
		

.vertical-centre (@height) {
    height:@height;
    line-height:@height !important;
    display:inline-block;
    vertical-align:middle;
}

.border-box {
    box-sizing:border-box;
    -moz-box-sizing:border-box;
}

@border-colour:#CCC;
calendar {
    float:left;
    display:block;
    .border-box;
    background:white;
    width:1000px;
    border:solid 1px @border-colour;
    margin-bottom:10px;

    @secondary-colour:#2875C7;
    @spacing:10px;
    @icon-width:40px;
    @header-height:40px;

	

    >div.header {
        float:left;
        width:100%;
        background:@secondary-colour;
        height:@header-height;
        color:white;

        >* { 
            .vertical-centre(@header-height);
        }

        >i {
            float:left;
            width:@icon-width;
            font-size:1.125em;
            font-weight:bold;
            position:relative;
            .border-box;
            padding:0 @spacing;
            cursor:pointer;
        }

        >i.fa-angle-left {
            text-align:left;
        }

        >i.fa-angle-right {
            text-align:right;
            margin-left:@icon-width*-1;
        }

        >span { 
            float:left;
            width:100%;
            font-weight:bold;
            text-transform:uppercase;
            .border-box;
            padding-left:@icon-width+@spacing;
            margin-left:@icon-width*-1;
            text-align:center;
            padding-right:@icon-width;
            color:inherit;
        }
    }
	
	
    >div.week {
        float:left;
        width:100%;
        border-top:solid 1px @border-colour;

        &:first-child {
            border-top:none;
        }
	
		

        >span.day {
            float:left;
            width:100%/7;
            .border-box;
            border-left:solid 1px @border-colour;
            font-size:0.75em;
            text-align:center;
            .vertical-centre(30px);
            background:white;
            cursor:pointer;
            color:black;
			height: 90px;
            &:first-child {
                border-left:none;
            }

            &.today {
                background:#E3F2FF;
            }

            &.different-month {
                color:#C0C0C0;
            }

            &.selected {
                background:@secondary-colour;
                color:white;
            }
        }

        &.names>span {
            color:@secondary-colour;
            font-weight:bold;			
			height: 40px;
        }

		
    }
}
</style>
		