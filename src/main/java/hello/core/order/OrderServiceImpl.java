package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //1. member조회
        Member member = memberRepository.findById(memberId);
        //2. 할인금액 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //주문 생성된 객체 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}