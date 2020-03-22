use strict;
use warnings;

#print "String collection...";
my $file = $ARGV[0];
my $searchStr = $ARGV[1];
open my $info, $file or die "Could not open $file: $!";

while( my $line = <$info>)  {  
if ($line=~ m/$searchStr/ ) {
    print $line; 
    }

}

close $info;