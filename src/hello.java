import java.util.ArrayList;

class User {
	String name;
	int[] score;
	
	public User(String name, int[] score){
		this.name = name;
		this.score = score;
		
	}
	
	String getName(){
		return this.name;
	}
	
	
	int getScore(int i){
		return this.score[i];
	}
	
	int[] getScoreList(){
		return this.score;
	}
	
	int getSum(){
		int sum = 0;
		for(int score:this.score){
			sum+=score;
		}
		return sum;
	}
	
	float getAverage(){
		return (float)this.getSum()/this.score.length;
	}
}

class Build{
	ArrayList<User> users = new ArrayList<User>();
	
	void setUserList(User user){
		this.users.add(user);
	}
	
	void getNameByUsers(){
		for(User name:this.users){
			System.out.println(name.getName());
		} 
	}
	
	
	float getAverage(int sum){
		return sum/3f;
	}
	
	void getTotal(){
		int index = this.users.get(0).getScoreList().length+2;
		float[] sum = new float[index];
		for(User user:this.users){
			int temp =0;
			for(int i=0;i<user.getScoreList().length;i++){
				sum[i]+=user.getScore(i);
				temp+=user.getScore(i);
			}
			sum[index-1] += temp/user.getScoreList().length;
			sum[index-2] += temp;
		}
		sum[index-1] = sum[index-1]/this.users.size();
			System.out.print("합계	");
		for(int i=0;i<sum.length;i++){
			if(i==sum.length-1){
				System.out.printf("%.2f	", sum[i]);
			}else{
				System.out.printf("%.0f	", sum[i]);
			}
		}
		
	}
	
	void getResult(){
		
		System.out.println("----------------------------------------------");
		System.out.println("이름	C#	java	HTML5	합계	평균");
		System.out.println("----------------------------------------------");		
		for(User user:this.users){
			System.out.printf("%s	",user.getName());
			for(int i=0;i<user.getScoreList().length;i++){
				System.out.printf("%d	",user.getScore(i));	
			}
			System.out.printf("%d	", user.getSum());
			System.out.printf("%2.2f	", user.getAverage());
			System.out.println("");
		}
		System.out.println("----------------------------------------------");	
		this.getTotal();
	}
}

public class hello {
	public static void main(String[] args){
		
		User user_1 = new User("홍길동",new int[] {90,80,70});
		User user_2 = new User("강감찬",new int[] {80,90,60});
		User user_3 = new User("유관순",new int[] {80,30,60});
		User user_4 = new User("이순신",new int[] {80,20,60});
		User user_5 = new User("김갑순",new int[] {70,90,60});

		Build build = new Build();
		build.setUserList(user_1);
		build.setUserList(user_2);
		build.setUserList(user_3);
		build.setUserList(user_4);
		build.setUserList(user_5);
		build.getResult();
	}
}



