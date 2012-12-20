<?php
    
  require "./functions.php";


print <<< EOT
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">
    <head profile="http://gmpg.org/xfn/11">
    <title>Google BCS</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="imagetoolbar" content="no" />
    <link rel="stylesheet" href="style.css" type="text/css" />
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="./js/jquery-ui.js"></script>
    <script type="text/javascript" src="./js/jquery.tablesorter.js"></script>
    <script type="text/javascript" src="./js/jquery.ui.core.js"></script>
    <script type="text/javascript" src="./js/jquery.ui.wiget.js"></script>
    <script type="text/javascript" src="./js/jquery.ui.datepicker.js"></script>


    <script>
	  $(function() {
		var dates = $( "#from, #to" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			onSelect: function( selectedDate ) {
				var option = this.id == "from" ? "minDate" : "maxDate",
					instance = $( this ).data( "datepicker" ),
					date = $.datepicker.parseDate(
						instance.settings.dateFormat ||
						$.datepicker._defaults.dateFormat,
						selectedDate, instance.settings );
				dates.not( this ).datepicker( "option", option, date );
			}
		});
	});
	</script>
    
    
    
    </head>

<body id="top">
<div class="wrapper col1">
  <div id="header">
    <div id="topnav">
      <ul>
        <li class="last"><a href="contact.html">Contact Us</a></li>
        <li><a href="">How it works</a>
          <ul>
            <li><a href="http://pr.efactory.de/e-pagerank-algorithm.shtml">General Information</a></li>
            <li><a href="http://pagerank.suchmaschinen-doktor.de/index/examples.html">Simple Graphs</a></li>
            <li><a href="http://www.aw-bc.com/greenwell/markov.pdf">Markov Chain</a></li>
          </ul>
        </li>
        <li><a href="about.html">About</a></li>
        <li class="active"><a href="gbcs3.php">Demo</a></li>
      </ul>
    </div>
    <div class="fl_left">
      <h1><a href="gbcs3.php"><font color="#73A2EF">G</font><font color="#FF7563">o</font><font color="#FFEF08">o</font><font color="#73A2EF">g</font><font color="#5ACB5A">l</font><font color="#FF7563">e</font> BCS</a></h1>
      <p>Built on PageRank technology</p>
    </div>
    <br class="clear" />
  </div>
</div>
    
<div class="wrapper col3">
  <div id="breadcrumb">
    <ul>
      <li class="first">You Are Here</li>
      <li>&gt;&gt;</li>
      <li><a href="gbcs3.php">Demo</a></li>
    </ul>
  </div>
</div>
    
EOT;

  if( empty($_POST)) // nothing sent to page, so print form
   {
      print <<< EOT
       
        <div class="wrapper col4">
          <div id="container">
             <div id="dataForRank">
	           <form method='post' action='$_SERVER[PHP_SELF]' id='myForm'>
	      	   <select name="theSport">
			     <option value="FB">Football</option>
			     <option value="BB">Basketball</option>
		       </select>&nbsp;&nbsp;&nbsp;
		       <select name="theYear">
			     <option value="2011">2011</option>
			     <option value="2010">2010</option>
			     <option value="2009">2009</option>
			     <option value="2008">2008</option>
                 <option value="2007">2007</option>
               </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

               <input class='searchBox' type='text' name='theStartDate' id='from' value='01/01/2007' size='10' /> - 
               <input class='searchBox' type='text' name='theEndDate' id='to' value='12/12/2012' size='10' /><br /> <br />


	           <input class ='searchBox' type='text' name='theDampingFactor' id='df' value='15' size='4' />
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <select name="topX">
                <option value="10">10</option>
                <option value="25" selected>25</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="999">ALL</option>
              </select>
               <br /><br />
       
               <p><input type="submit" name="mysubmit" id="submit" value="Submit" /></p>
       
              </form>
         </div>
        </div>
       </div>
     </div>
EOT;
    }
  else // we have posted data, check for it
    {
      // get parameters posted from form
      $sport = htmlentities(stripslashes($_POST['theSport']),ENT_QUOTES);
      $year = htmlentities(stripslashes($_POST['theYear']),ENT_QUOTES);
      $startDate = htmlentities(stripslashes($_POST['theStartDate']),ENT_QUOTES);
      $endDate = htmlentities(stripslashes($_POST['theEndDate']),ENT_QUOTES);
      $dampingFactor = htmlentities(stripslashes($_POST['theDampingFactor']),ENT_QUOTES);
      $topX = htmlentities(stripslashes($_POST['topX']),ENT_QUOTES);
      $dateMatters = "false";
      $homeFieldMatters = "false";
      
      
        if($sport == "FB") { $longSport = "Football"; }
        else if($sport == "BB") { $longSport = "Basketball"; }

      if($sport == "" || $year == "")
      {
	     print "Error - Please enter data.\n".
	        "<a href='./gbcs3.php'>Go back</a>\n";
	   }
      
      else
	  {
	    print " <div class='wrapper col4'> <div id='container'>" .
              " <b> $year $longSport season from $startDate - $endDate<br />" .
              " <b>Damping factor:</b> $dampingFactor </font><br />" .
              " <p><a href='./gbcs3.php'>Return</a></p>";


    exec('java -jar googleBCS.jar '.$sport.' '.$year.' '.$startDate.' '.$endDate.' '.$dampingFactor.' '.$dateMatters.' '.$homeFieldMatters);


	while(!file_exists('output.xml'))
	{
		sleep(1);
	}	
	$trm = simplexml_load_file('output.xml');

	echo <<<EOF
	<table id="myTable" class="tablesorter">
	<thead> 
	<tr> 
        <th></th>
	    <th></th> 
	    <th width="10%">Team</th> 
	    <th>PageRank</th> 
	    <th width="7%">BCS</th>
        <th>Wins</th> 
	    <th>Losses</th>
	</tr> 
	</thead>
    <tbody>
EOF;
        
        
    $count = 0;
        
	foreach($trm as $record)
	{
        if($count == $topX)
        {
            break;
        }

        
        $count++;
        $color = "light";
        
        if($count % 2 == 0)
        {
            $color = "dark";
        }
        
	$bcs = "{$record->bcsRank}";
		if($bcs == 0)
		{
			$bcs = "0";
		}
		echo <<<EOF
        
		<tr class = "$color">
        
            <td align = "middle">$count</td>
			<td align = "right"><img src="{$record->iconURL}" width=32/></td>
			<td align = "middle"><b>{$record->team}</b></td>
			<td align = "center">{$record->pageRank}</td>
			<td align = "center">$bcs</td>
            <td align = "center"><b>{$record->numWins}</b><br />{$record->winCollection}</td>
            <td align = "center"><b>{$record->numLosses}</b><br />{$record->lossCollection}</td>
			
		</tr>
EOF;
	}
    echo '</tbody>';
	echo '</table>';
    echo '</div>';
    echo '</div>';

//script 1:  makes the table sortable
print <<< EOT
<script type="text/javascript">
    $(document).ready(function() 
        { 
            $("#myTable").tablesorter(); 
        });
</script>
EOT;


	}
 }

        PrintDocFooter();
    
?>
