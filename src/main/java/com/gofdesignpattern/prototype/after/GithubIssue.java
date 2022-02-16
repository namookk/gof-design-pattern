package com.gofdesignpattern.prototype.after;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class GithubIssue implements Cloneable{
    private int id;

    private String title;

    private GithubRepository repository;

    public GithubIssue(GithubRepository repository){
        this.repository = repository;
    }

    public String getUrl(){
        return String.format("https://github.com/%s/%s/issues/%d",
                repository.getUser(),
                repository.getName(),
                this.getId()
        );
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //기본기능은 얕은 복사를 사용하게 됨
        //return super.clone();

        GithubRepository repository = new GithubRepository();
        repository.setUser(this.repository.getUser());
        repository.setName(this.repository.getName());

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(this.id);
        githubIssue.setTitle(this.title);
        return githubIssue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubIssue that = (GithubIssue) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, repository);
    }
}