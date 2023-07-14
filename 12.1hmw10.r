#1)
#H0 the coloring purportions are correct
#H1 The coloring purportions are incorrect
p1 <- c(.13,.14,.13,.24,.2,.16)
o1 <- c(121,84,118,226,226,123)
s1 <- sum(o1)
e1 <- s1*p1
chi1 = sum((o1-e1)^2/e1)
1-pchisq(chi1, df = 5)
#[1] 1.860203e-05
#reject the null and conclude H1
#2)
#h0 the leading digits of town populations follow benfords law
#H1 the leading digits of town populations do not follow benfords law
num2 <- c(1,2,3,4,5,6,7,8,9)
pmf2 <- log10(1+(1/num2))
pmfcheck2 <- sum(pmf2)
# pmf checks out 

o2 <-c(107,55,39,22,13,18,13,23,15)
numo2 <- sum(o2)
e2 <-pmf2 *numo2
chi2 = sum((o2-e2)^2/e2)
1-pchisq(chi2, df = 8)
#[1] 0.06399094
#we accept the null beacuse its over .05


#3)
#H0 a patient's response to treatment for Hodgkin's disease does not vary by histological type
#H1 a patient's response to treatment for Hodgkin's disease varies by histological type
tab3 <- matrix(c(74, 18,12,68,16,12,154,54,58,18,10,44), ncol=3, byrow=TRUE)
colnames(tab3) <- c('Positive','Partial','None')
rownames(tab3) <- c('LP','NS','MC','LD')
exp.val = function(x){
  n = sum(x)
  n.row = apply(X=x,MARGIN=1,FUN=sum)
  n.col = apply(X=x, MARGIN = 2, FUN = sum)
  expected = outer(X=n.row,Y = n.col)/n
  expected
  
}
e3 <-exp.val(tab3)
chi3 =sum((tab3-e3)^2/e3)
1-pchisq(chi3,df=6)
#[1] 2.520206e-14
#using is I have determined that these events are not indepenedent and I will reject the null


#4)
tab4 <- matrix(c(512,89,353,17,120,202,138,131,53,94,16,24), ncol=2, byrow=TRUE)
colnames(tab4) <- c('Men','Women')
rownames(tab4) <- c('A','B','C','D','E','F')
e4 <- exp.val(tab4)  
#Men     Women
#A 409.60091 191.39909
#B 252.16695 117.83305
#C 219.45340 102.54660
#D 183.33219  85.66781
#E 100.18525  46.81475
#F  27.26129  12.73871
#expected values^
#yes the sample size is large enough to perform a test
# we are using a independence chi squared test 
chi4 =sum((tab4-e4)^2/e4)
# the test stat is 468.0996
chisqrtest4 <- 1 -pchisq(chi4,5)
# our p value is 0 
# the p value is 0 which is ludicrously low, like as low as it can possibly go,
#therefore we reject the null and decide that the gender to department relationship is dependent
#c)
#this means that some genders will favor other departments over others.