#! /bin/ksh

file=$1
parts=$2

allcount=`wc -l < $file`
chunkSize=`echo $(( $allcount / $parts ))`
remainder=`echo $(( $allcount % $parts ))`

chunkSize=`echo $(( $chunkSize + $remainder ))`

split -a 4 -l $chunkSize $file datapart.
