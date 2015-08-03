for i in `cat list`; do
echo dir of $i
cd $i
jant
jant run
jant undeploy
cd -
done