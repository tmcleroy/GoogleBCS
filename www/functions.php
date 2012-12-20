<?php

function printDocFooter()
{
  print "<div class='wrapper col5'> \n" ;
  print "<div id='footer'>"."\n" ;
  print "<p class='fl_left'>Copyright &copy; 2012 - All Rights Reserved - <a href='gbcs3.php'>Google BCS</a></p>" .
        "<p class='fl_right'>Page Last Updated:\n " .
        " <script type='text/javascript'>\n " .
        " document.write(document.lastModified); \n" .
        " </script> &nbsp;&nbsp;&nbsp; \n" .
        " <br class='clear' />";
  print "</div>\n ";
  print "</div>\n";  // end of maincontent
  print "</body>\n</html>\n";
} 
// outputs the standard text filler for use in 
// testing out pages
function printTextFiller($numParagraphs = 1)
{
 $text1 = " Lorem ipsum dolor sit amet, consectetur adipisicing elit," . "\n" .
       " sed do eiusmod tempor incididunt ut labore et dolore magna" . "\n" . 
       " aliqua. Ut enim ad minim veniam, quis nostrud exercitation " . "\n" .
       " ullamco laboris nisi ut aliquip ex ea commodo consequat. " . "\n".
       " Duis aute irure dolor in reprehenderit in voluptate velit " . "\n".
       " esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " . "\n".
       " occaecat cupidatat non proident, sunt in culpa qui officia " . "\n".
       " deserunt mollit anim id est laborum. " .  "\n";
   $text2 = "Nunc velit dolor, consequat vel elementum a, sollicitudin "."\n".
     "eget nulla. Quisque imperdiet faucibus arcu, at rutrum sem " . "\n".
     "malesuada tempor. Ut rhoncus convallis placerat. Pellentesque " . "\n".
     "varius justo odio. Quisque eu sem leo, nec rutrum tellus. " . "\n".
     "In hac habitasse platea dictumst. Nulla dictum accumsan " . "\n".
     "facilisis. Quisque vitae dolor eu velit faucibus volutpat. " . "\n".
     "Cras non lectus id nibh pulvinar tincidunt. Donec facilisis " . "\n".
     "pharetra eros ullamcorper tempor. Praesent non ullamcorper urna. "."\n".
     "Quisque eget nisl id massa convallis aliquet in laoreet felis. " ."\n".
     "Nulla facilisi. Pellentesque sodales, risus id semper gravida, " . "\n".
     " nisi elit aliquam nunc, in hendrerit urna risus eu purus. " . "\n".
     "Sed condimentum tempus condimentum. Mauris lacinia viverra " . "\n".
     "eros sed sollicitudin. Maecenas tincidunt luctus tortor, " . "\n".
     " ac bibendum lorem molestie id. Proin hendrerit diam eu " . "\n".
     " libero consequat in aliquet nibh commodo. " . "\n" ; 
for($i=0;$i< $numParagraphs ; $i++) {
  if ($i%2==0){
    print $text1;
  }
  else{
    print $text2;
  }
  print "<br />\n";
}
}



# uploadFile creates a form which prompts the user to                                             
# upload an image along with a desired width for the                                              
# new thumbnail image.  Default width is set to 100.                                              
function uploadFile()
{
print "<div class='content'> \n " .
  "<form method = 'post' action = '$_SERVER[PHP_SELF]' enctype = 'multipart/form-data'> 
\n".
  "<h4>  Choose an image file:  </h4> \n " .
  "<p><input type= 'file' name='file' id='file'/> <br/></p> \n " .
  "<h4> Set width (25-100px):  </h4>\n <p> " .
  "<input type='text' name='width' size='3' /> <br/><br/> \n " .
  "<input type='submit' name='submit' value='Upload'/> </p> \n " .
  "</form></div>";
}                                                                                                  


# displayImages first checks file format and
# displays the original image; once this happens
# the thumbnail is created and displayed alongside
function displayImages()
{

  # file type of uploaded image is checked
  if ((($_FILES["file"]["type"] == "image/gif")
       || ($_FILES["file"]["type"] == "image/jpeg")
       || ($_FILES["file"]["type"] == "image/pjpeg"))
       && ($_FILES["file"]["size"] < 2000000))
     {
      # if an error occurs print message
      if ($_FILES["file"]["error"] > 0)
       {
         print "Return Code: " . $_FILES["file"]["error"] . "<br />";
       }
      # display the original image and thumbnail
      else
       {
         $filename= $_FILES['file']['tmp_name'];
         $temp ="../temp/".$_FILES['file']['name'];
         # if the image fails to load $alt prints name
         $alt = $_FILES['file']['name'];
         # moves image
         move_uploaded_file($filename, $temp);
        
          # display original image
          print "<div class = 'content'> \n " .
                "<h4> Original Image: </h4> " .
                "<img src='".$temp."' alt='".$alt."' />";
          
          # grabs width from post array
          $width = $_POST['width'];
          # if the width is <25 or >100 set default to 100
          if($width < 25 || $width > 100)
            {
             $width = 100;
            }
            
          # prepend 'Thumbnail' on all files to differentiate
          $thumbNail ="../temp/Thumbnail".$_FILES['file']['name'];
          # calls createThumb to display the new thumbnail
          createThumb($temp, $thumbNail, $width);
          print "<h4> Thumbnail: </h4>";
          print "<img src='$thumbNail' alt='Thumbnail ".$alt."' /> \n " .
            "<h4> <a href ='./asg5.php'> go back </a></h4> \n " .
            "</div>";
        }
    }

  # if problem with filetype print error message
  else
    {
      print "Improper File Type";
    }
}


# createThumb provided by Dr. Baker; it takes a jpeg image
# file and creates a thumbnail image from it

function createThumb( $imageFile, $thumbFile, $thumbWidth )
{
  // echo "Creating thumbnail for $imageFile <br />";

  // load image and get image size
  $img = imagecreatefromjpeg( "$imageFile" );
  $width = imagesx( $img );
  $height = imagesy( $img );

  // calculate thumbnail size
  $new_width = $thumbWidth;
  $new_height = floor( $height * ( $thumbWidth / $width ) );

  // create a new temporary image
  $tmp_img = imagecreatetruecolor( $new_width, $new_height );

  // copy and resize old image into new image
  imagecopyresized( $tmp_img, $img, 0, 0, 0, 0, 
                    $new_width, $new_height, $width, $height );

  // save thumbnail into a file
  imagejpeg( $tmp_img, "../temp/$thumbFile" );
}



?>



