package com.gofdesignpattern.prototype.before;

public class App {
    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("namookk");
        repository.setName("design-pattern-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제 : 싱글톤 패턴은 무엇인가?");

        String url = githubIssue.getUrl();
        System.out.println(url);

        GithubIssue githubIssue2 = new GithubIssue(repository);
        githubIssue.setId(2);
        githubIssue.setTitle("2주차 과제 : 팩토리메소드 패턴은 무엇인가?");

        String url2 = githubIssue2.getUrl();
        System.out.println(url2);
    }
}
