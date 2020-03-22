use strict;
use warnings;

my $file = $ARGV[0];
open my $info, $file or die "Could not open $file: $!";

while( my $line = <$info>)  {  

	chomp($line);
	my @x = split( /`/, $line);
	print "$x[2]\n";
	
		



}

close $info;