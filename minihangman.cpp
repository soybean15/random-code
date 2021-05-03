#include<iostream>
#include<vector>
#include<ctime>
#include<cstring>
using namespace std;

string border[15][40];
int option;
 string start[13]={"[","1","]","S","t","a","r","t"," ", "G","a","m","e"};
 string exitGame[13]={"[","2","]","E","x","i","t"," ","G","a","m","e"};
 string bye[13]= {" ","T","H","A","N","K"," ","Y","O","U","<","3"," "};
string blank[13]={" " ," "," "," "," "," "," "," "," ", " "," "," "," "};;
//vector<string>answer{"*"," ","*"," ","*"," ","*"," ","*"," ","*"," ","*"," ","*"," ","*"," ","*"," ","*"," ","*","  "};
vector<string>answer;
string letter;
vector<string >word1{""," "," "," "," "," "," "," "," "," "," "," "};
string gameOver[10]={"G","A","M","E"," ","O","V","E","R","!"};
string youWin[10]={"Y","O","U"," "," ","W","I","N","!","!"};

vector<string>wordList{"avenue","wizard","whizkey","transfer","fan","feline"};

string lvl[5]={"L","e","v","e","l"};


int score[4]={0,0,0,0};
int index=0;
int getIndex;
int tries =7;
int id=0;
int level=1;
int countscore=0;


string generateWord(){
  srand(time(0));
  string word;
   int  shuffle = rand()%wordList.size();  
   
   word= wordList[shuffle]; 
   
  for(int i=0;i<=word.length();i++){
  	answer.push_back("*");
  	answer.push_back(" ");
  	word1[i]=word[i];
  	
  }
  
  answer.pop_back();
  answer.pop_back();
return word ;   
     
}

int changeScore(){
	int d3 = score[2];
	int d2 =score[1];
	int d1= score[0];

	if(score[2]==9){
		score[2]=0;
		countscore=0;
		
		if(score[1]==9){
			score[1]=0;
			score[0]+=1;
		}else{
			score[1]+=1;
		}
	}else{
		score[2]=countscore;
	}

}


void printHangman(string s1[13], string s2[13]){

	//H
	border[2][2]="*";		
	border[2][5]="*";
	border[4][3]="*";
	border[4][4]="*";
	border[3][2]="*";		
	border[4][2]="*";
	border[5][2]="*";	
	border[3][5]="*";		
	border[4][5]="*";
	border[5][5]="*";
	

	//A
	   border[2][8]="*";
	   border[3][7]="*";
	   border[4][7]="*";
	   border[5][7]="*";
	   border[4][8]="*";
	   border[4][9]="*";
	   border[3][9]="*";
	   border[5][9]="*";
	//N
	   border[5][11]="*";
	   border[4][11]="*";
   	border[3][11]="*";
   	border[2][11]="*";
   	border[3][12]="*";
   	border[4][13]="*";
   	border[5][14]="*";
   	border[4][14]="*";
       border[3][14]="*";	
       border[2][14]="*"; 
    //G
       border[5][17]="*";
	   border[5][18]="*";
   	border[4][16]="*";
   	border[3][16]="*";
   	border[2][17]="*";
   	border[2][18]="*";
   	border[4][19]="*";
   	border[4][18]="*";
    //M
       border[5][21]="*";
	   border[4][21]="*";
   	border[3][21]="*";
   	border[2][21]="*";
   	border[5][23]="*";
   	border[4][22]="*";
   	border[4][24]="*";
   	border[5][25]="*";
	   border[4][25]="*";
   	border[3][25]="*";
   	border[2][25]="*";
  	
      //A
       border[2][28]="*";
	   border[3][27]="*";
	   border[4][27]="*";
	   border[5][27]="*";
	   border[4][28]="*";
	   border[4][29]="*";
	   border[3][29]="*";
	   border[5][29]="*";
	   //N
	   border[5][31]="*";
	   border[4][31]="*";
   	border[3][31]="*";
   	border[2][31]="*";
   	border[3][32]="*";
   	border[4][33]="*";
   	border[5][34]="*";
   	border[4][34]="*";
       border[3][34]="*";	
       border[2][34]="*"; 
       
       for(int i=10, j=0; i<23;i++){
       	border[10][i]=s1[j++];
       	
       } 
       for(int i=10, j=0; i<22;i++){
       	border[11][i]=s2[j++];
       	
       }
 
}

void gameFrame1(string b1[13],string b2[13]){
	
	for(int i=0; i<15; i++){
		for(int j=0; j<40; j++){
			border[i][j] = " ";
			  printHangman( b1,b2);
		if(j==0 || j ==39){
				border[i][j]="|";
			}
    	if(i ==0 || i==14){
			   border[i][j]="-";
				
			}	
			cout<<border[i][j];
		}
		cout<<endl;
	}
	
}

void frame2(int score[4]){
	 string panel1[5]={"S","c","o","r","e"};
	 string panel1_2[5]={"T","r","i","e","s"};
	 
	 string panel3_1[24]={"[","1","]","G","u","e","s","s"," ","t","h","e"," ","w","o","r","d"," ","o","r"," ","d","i","e"};
	 string panel3_2[20]={"S","c","o","r","e"};
	 
	 border[7][6]=to_string(tries);
	 
	 for(int i=4, j=0; i<9;i++){
	 	  border[2][i]=panel1[j++];
	 }
	 
	for(int i=4, j=0; i<9;i++){
	 	  border[6][i]=panel1_2[j++];
	 } 
	 
	 for(int i=4, j=0; i<8;i++){
	 	  border[3][i]=to_string(score[j++]);
	 }
	 
     for(int i=4, j=0; i<28;i++){
	 	  border[11][i]=panel3_1[j++];
	 }
}

void frameLowerPanel(vector<string> answer){
     
   int  left= 13 - answer.size();
   int lindex= (left/2)+11;
 
   
   for(int i=0 ; i<left+7;i++){
   	answer.push_back(" ");
   }

     for(int i=lindex, j=0; i<29;i++){
      	
	 	  border[12][i]=answer[j++];
	 }
}

	
bool checkWinner(){
	      
	     for(int i=4, j=0; i<29;i++){
      	if (border[12][i]=="*"){
      		return true;
	 }
}
}
bool checkExisting(string letter){
	      
	     for(int i=4, j=0; i<29;i++){
      	if (border[12][i]==letter){
      		return true;
	 }
}
}


void panel2(int count){
	//sabitan
	border[1][30]="_";
	border[1][31]="_";
	border[1][32]="_";
	border[1][33]="_";
	//poste
	border[4][33]="|";
	border[2][33]="|";
	border[3][33]="|";
	border[1][33]="|";
	border[5][33]="|";
	//platform
	border[5][30]="_";
	border[5][31]="_";
	border[5][32]="_";
	border[5][34]="_";
	border[5][35]="_";
	//prisoner
	if (count==1){
	border[2][30]="O";
	}
	if (count==2){
	border[2][30]="O";
	border[3][30]="|";
	}
	if(count==3){
	border[2][30]="O";
	border[3][30]="|";
	border[3][29]="/";	
	}
	if (count==4){
	border[2][30]="O";
	border[3][30]="|";
	border[3][29]="/";	
	}
	if (count==5){
	border[2][30]="O";
	border[3][30]="|";
	border[3][29]="/";
    border[3][31]="\\";
	}
	if (count==6){
	border[2][30]="O";
	border[3][30]="|";
	border[3][29]="/";
    border[3][31]="\\";
    border[4][29]="/";
	}
	if (count==7){
	border[2][30]="O";
	border[3][30]="|";
	border[3][29]="/";
    border[3][31]="\\";
    border[4][29]="/";
	border[4][31]="\\";
	}
	border[2][17]=to_string(level);
	for(int i=15, j=0; i<20;i++){
	 	  border[1][i]=lvl[j++];
		}
		
	if(tries==0){
		for(int i=18, j=0; i<28;i++){
	 	  border[7][i]=gameOver[j++];
		}
	 }else if(!checkWinner()){
	 	for(int i=18, j=0; i<28;i++){
	 	border[7][i]=youWin[j++];
	 	
	 	}
	 	
	 }
	}




void changeAnswerBox(){
	
	int idx=12;
	for(int i=0; i<word1.size();i++){
		if (word1[i]==letter){
			idx=i;
		}
		answer[idx*2]= word1[idx];
	}

}


void gameFrame2(int score[4]){
	
	for(int i=0; i<15; i++){
		for(int j=0; j<40; j++){
			border[i][j] = " ";
					
		if(j==0 || j ==39 || j==13){
				border[i][j]="|";
			}
    	if(i ==0 || i==14 || i==9){
			   border[i][j]="-";
				
			}
	 	if(i>9 && i<14 && j== 13){
	    	border[i][j] = " ";
	    }
	    
	    panel2(id);
 	   changeAnswerBox();
 	   
	    frame2(score);
	    frameLowerPanel(answer);
	    
	    
		cout<<border[i][j];
			
		}
		cout<<endl;
	}
	
}




bool checkAnswer(){
	
	for(int i=0; i<12;i++){
		if(word1[i]==letter ){
		  
   		return true;	
		
	}
}

}

int main(){
   
 string x;
 string next;
	gameFrame1(start,exitGame);
	cout<<"Select Option: ";
	cin>>option;


	if(option == 1){
	
		 
		 
	     generateWord();	
		 while(tries>=0 ){  
		  
		 system("clear");
	
		 gameFrame2(score);
   	  if(!checkWinner()){
        	id=0;
        	tries=7;
        	answer.clear();
        	generateWord();	
        	level++;
        	cout<<"level "<<level;
        	cin>>next;
            system("clear");
	
		 gameFrame2(score);
        }   
        	 	
		 cout<<"Enter a letter: ";
		 cin>>x;
		 letter=x;
		 if(!checkAnswer() || checkExisting(letter)){
    			 
		 	id++;
		 	tries-=1;
		 	
		 }else{		 	
		 countscore+=1;	
		 changeScore();			
		 }
		
		 frameLowerPanel(answer);			 

        
	}	 
		 
	}else if(option == 2){
		 system("clear");
          
		 gameFrame1(blank,bye);
		 return 0;
	}
	
	
	
}
