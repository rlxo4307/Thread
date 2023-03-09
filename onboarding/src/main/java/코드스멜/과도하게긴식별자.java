package 코드스멜;

import java.util.Scanner;

class 과도하게긴식별자 {
    Scanner sc = new Scanner(System.in);

    public void bmi지수에따른식단과운동추천그리고체형에맞는옷추천함수(int tall, int kg){
        double result = kg / (tall*tall);
        String state;

        if(result >= 25.0){
            state = "비만";
        }else if(result >= 23.0){
            state = "과체중";
        }else if(result >= 18.5){
            state = "정상";
        }else{
            state = "저체중";
        }

        if(state.equals("비만")) System.out.println("유산소 운동과 식단 조절, 금주가 필요합니다.");
        else if(state.equals("과체중")) System.out.println("유산소 운동과 식단 조절이 필요합니다.");
        else if(state.equals("정상")) System.out.println("현재 식단과 규칙적인 생활을 유지하세요.");
        else System.out.println("탄수화물 위주의 식단과 무산소 운동이 좋습니다.");


        if(state.equals("비만")) System.out.println("지방, 기름진 음식을 피하고 야채, 채소, 단백질 섭취를 권합니다.");
        else if(state.equals("과체중")) System.out.println("잡곡밥, 고구마 등의 GI가 높은 탄수화물을 추천합니다.");
        else if(state.equals("정상")) System.out.println("단밸질 위주의 식사를 추천합니다.");
        else System.out.println("탄수화물, 지방, 단백질을 골고루 섭취하세요.");


        if(state.equals("비만")){
            System.out.println("프리 사이즈를 추천합니다.");
            return;
        }
        if(state.equals("과체중")){
            System.out.println("프리 사이즈 혹은 한 치수 큰 사이즈를 추천합니다.");
            return;
        }
        if(state.equals("정상")){
            System.out.println("핏에 알맞은 옷을 추천합니다.");
        }else{
            System.out.println("한 치수 작은 사이즈를 추천합니다.");
        }
    }
}
