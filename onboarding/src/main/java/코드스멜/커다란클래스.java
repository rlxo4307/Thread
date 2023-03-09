package 코드스멜;

class 커다란클래스 {
    double bmi(int tall, int kg){
        double result = kg / (tall*tall);
        return result;
    }

    void result(double bmi){
        if(bmi >= 25.0){
            System.out.println("비만");
        }else if(bmi >= 23.0){
            System.out.println("과체중");
        }else if(bmi >= 18.5){
            System.out.println("정상");
        }else{
            System.out.println("저체중");
        }
    }

    void activeList(String result){
        if(result.equals("비만")){
            System.out.println("유산소 운동과 식단 조절, 금주가 필요합니다.");
        }else if(result.equals("과체중")){
            System.out.println("유산소 운동과 식단 조절이 필요합니다.");
        }else if(result.equals("정상")){
            System.out.println("현재 식단과 규칙적인 생활을 유지하세요.");
        }else{
            System.out.println("탄수화물 위주의 식단과 무산소 운동이 좋습니다.");
        }
    }

    void foodList(String result){
        if(result.equals("비만")){
            System.out.println("지방, 기름진 음식을 피하고 야채, 채소, 단백질 섭취를 권합니다.");
        }else if(result.equals("과체중")){
            System.out.println("잡곡밥, 고구마 등의 GI가 높은 탄수화물을 추천합니다.");
        }else if(result.equals("정상")){
            System.out.println("단밸질 위주의 식사를 추천합니다.");
        }else{
            System.out.println("탄수화물, 지방, 단백질을 골고루 섭취하세요.");
        }
    }

    void clothRecommend(String result){
        if(result.equals("비만")){
            System.out.println("프리 사이즈를 추천합니다.");
        }else if(result.equals("과체중")){
            System.out.println("프리 사이즈 혹은 한 치수 큰 사이즈를 추천합니다.");
        }else if(result.equals("정상")){
            System.out.println("핏에 알맞은 옷을 추천합니다.");
        }else{
            System.out.println("한 치수 작은 사이즈를 추천합니다.");
        }
    }

}