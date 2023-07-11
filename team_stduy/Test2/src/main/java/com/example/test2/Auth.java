package com.example.test2;

// enum은 관련 있는 상수들을 모아놓는 얘들
// 클래스와 객체로 풀어낸거에요.

// 상수라고 하는 것은 ADMIN_TOKEN = "DFSFDwerewrwerwerwe" (변하지 않는 값)

// 상수 => 변하지 않는 객체 USER = new USER("ROLE_USER");
//
public enum Auth {
    USER("ROLE_USER"), // 사용자 권한
    ADMIN("ROLE_ADMIN"); // 관리자 권한

    // 무조건 하나만 만들어집니다. 2개 못 만들어요. 클래스가 1개의 객체만 못 만들 때 그걸 싱글톤이라고 해요.

    // 2개를 만들 수 있으면 어떤거 써야 되?
    // 3개를 만들

    private final String authority;

    Auth(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }
}
