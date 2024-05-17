package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        //1. 멤버 생성(메모리에 저장하고있어서 실행시마다 멤버추가)
        Long memberId = 1L;
        Member member = new Member(memberId, "membera", Grade.VIP);
        memberService.join(member);

        //2. 주문생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());


    }
}
