#include<iostream>
#include<ctime>
#include<cstring>
#include<string>

using namespace std;

char board[15][30];
char board2[15][30];

string remarks="";
int atk;
int miss;
int hit;
int score=0;
float accuracy ;
string s1=" ";
string s2=" ";
string s3=" ";
int ship1=3;
int ship2=3;
int ship3=3;
int row[]={1,3,5,7,9,11,13};
int col[]={2,6,10,14,18,22,26};

void scoreBoard(){
	cout<<"Target :"<<remarks<<endl;
	cout<<"Ship 1 : hp"<<ship1<<"/3 ";
	cout<<s1<<endl;
	cout<<"Ship 2 : hp"<<ship2<<"/3 ";
	cout<<s2<<endl;
	cout<<"Ship 3 : hp"<<ship3<<"/3 ";
	cout<<s3<<endl;
	cout<<endl;
	cout<<"Attack: "<<atk<<endl;
	cout<<"Hit: "<<hit<<endl;
	cout<<"Miss: "<<miss<<endl;
	cout<<"Score: "<<score<<endl;

}

void finalScore(){
	cout<<"Attack: "<<atk<<endl;
	cout<<"Hit: "<<hit<<endl;
	cout<<"Miss: "<<miss<<endl;
	cout<<"Score: "<<score<<endl;

    accuracy =((float)hit/(float)atk)*100;
    cout<<"Accuracy: "<<accuracy<<"%";
}

void generateLetter(){
	cout<<"  ";
	for(int i='A'; i<='G'; i++){
		cout<<(char)i<<"   ";
	}
	cout<<endl;

}

void deployShip(int r, int c, int shipPos, int j){

	int pos=0;
	int start=0;
	int end = 0;

	//vert
	if(shipPos==1){

		pos= row[r];
		start= col[c];
		end=start+12;

		char block = 1;
		for(int i=start;i <end;i+=4){
	    if(j==0){
	    	block='1';

	    }
	    else if(j==1){
	    	block='2';

	    }
	    else if(j==2){
	    	block='3';

	    }
		board[pos][i]=block;

		}
	}else
	{//horizontal
        char block=1;

	    pos =col[c];
	    start=row[r];
		end=start+6;

		for(int i=start;i <end;i+=2){
            if(j==0){
                block='1';
            }
            else if(j==1){
                block='2';
            }
            else if(j==2){
                block='3';
            }
            board[i][pos]=block;

		}
	}

}

void prepareShip(){
	srand(time(0));
	int i=0;

	//prepare 3 ships
	while(i<3){
    //generate ship pos: 1=vert, 2=hori
	int shipPos = rand() % (2+1-1)+1;

	int r ;
	int c;
	if(shipPos ==1){//vert
	     if(i==0){
	     	r=rand()%(3+1-0)+0;
	     	c =rand()%(1+1-0)+0;
	     }else if(i==1){
	     	c=4;
	     	r=rand()%(6+1-0)+0;
	     }else if(i==2){
	     	c=0;
            r=rand()%(6+1-4)+4;
	     }

	}else{//horizontal
	     if(i==0){
	     	r=rand()%(1+1-0)+0;
	     	c =rand()%(3+1-0)+0;
	     }else if(i==1){
	     	r=rand()%(4+1-1)+1;
	     	c=rand()%(6+1-4)+4;
	     }else if(i==2){
	     	r=4;
            c=rand()%(3+1-0)+0;
	     }
	}

	deployShip(r, c,shipPos,i);
	i++;
}

}



void generateBoard(){
	for(int i=0; i<15; i++){
		for(int j=0; j<29; j++){
			if(i%2==0 && j%4 ==0){
				board[i][j]='+';
				board2[i][j]='+';
			}
			else {
				board[i][j]=' ';
				board2[i][j]=' ';
			}
			if(i%2!=0 && j%4==0){
				board[i][j]='|';
				board2[i][j]='|';
			}
			else if(j%4!=0&& i%2==0){
				board[i][j]='-';
				board2[i][j]='-';
			}

		}
	}
	prepareShip();
	//GenerateShip();
	scoreBoard();
    generateLetter();
    int x=1;
    for(int i=0; i<15; i++){
		for(int j=0; j<30; j++){

            cout<<board2[i][j];

		}
		if(i%2!=0){
		cout<<x++;
		}
		cout<<endl;

	}



}

void showBoard(){
	scoreBoard();
	generateLetter();
	int x=1;
	for(int i=0; i<15; i++){
		for(int j=0; j<30; j++){
            cout<<board2[i][j];

		}

        if(i%2!=0){
            cout<<x++;
		}
		cout<<endl;
	}




}

void generateAttack(string attack){
    int a1 = attack[0]-96;
    int a2 = attack[1]-48;

    int _row[]={1,3,5,7,9,11,13};
    int _col[]={2,6,10,14,18,22,26};

	int c=_col[a1-1];
	int r=_row[a2-1];


	string target="HIT!!";
	if(board[r][c]!=' '){
		remarks=" ";
		if(board[r][c]=='1'){
			ship1--;
			s1=target;

			if(ship1==0){
				s1="Destroyed";
			}
		}
        else if(board[r][c]=='2'){
			ship2--;
			s2=target;
			if(ship2==0){
				s2="Destroyed";
			}

		}
		else if(board[r][c]=='3'){
			ship3--;
			s3=target;
			if(ship3==0){
				s3="Destroyed";
			}
		}

		board2[r][c]='x';
		hit++;
		score+=10;
    }else{
    	s1="";
    	s2="";
    	s3="";
    	if(ship1==0){
				s1="Destroyed";
			}
   	if(ship2==0){
				s2="Destroyed";
		}
		if(ship3==0){
				s3="Destroyed";
			}
		remarks="MISS!!";
		board2[r][c]='-';
		miss++;

	}
	cout<<endl;

}


int getrow(string attack){
    int r = attack[0]-96;

    int _row[]={1,3,5,7,9,11,13};
    return _row[r-1];
}
int getcolumn(string attack){

    int c = attack[1]-48;
    int _col[]={2,6,10,14,18,22,26};

	return _col[c-1];

}
bool checkBoard(string str){
    
    int column = str[0]-96;
    int row = str[1]-48;

    int _row[]={1,3,5,7,9,11,13};
    int _col[]={2,6,10,14,18,22,26};

    int r=_row[row-1];
	int c=_col[column-1];

 	if(board2[r][c]!=' '){
        return true;
 	}else{
 	    cout<<"false";
 	    return false;
 	}

}

bool invalidAttack(string str){

	 string moves[]={"a1","a2","a3","a4","a5","a6","a7","b1","b2","b3","b4","b5","b6","b7","c1","c2","c3","c4","c5","c6","c7","d1","d2","d3","d4","d5","d6","d7","e1","e2","e3","e4","e5","e6","e7","f1","f2","f3","f4","f5","f6","f7","g1","g2","g3","g4","g5","g6","g7"};

	 for(int i=0;i <49;i++){
	 	if(str==moves[i] ){
            return true;
	 	}
    }
}

int main(){

generateBoard();

while(true){

  string attack;
  cin>>attack;

  if (!invalidAttack(attack) ){
  	cout<<"Invalid Move"<<endl;
  	cout<<"Try again: ";
  }else{
     

      if(checkBoard(attack)){

        cout<<"Move already picked!";
        cout <<endl;
        cout<<"Try again: ";

      }else{
          system("clear");
          generateAttack( attack);
          atk++;
          showBoard();
    }
  }

  if(ship1<=0 && ship2<=0 && ship3 <=0){
   //	if(ship1<=0){
   	break;
   }


}
  cout<<"Congrats! You Win!!"  ;
  cout<<endl;
  finalScore();


}
