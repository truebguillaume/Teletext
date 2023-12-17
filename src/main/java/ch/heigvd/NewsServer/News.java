package ch.heigvd.NewsServer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class News {
    private String type;
    private String news;
    private boolean isBreakingNews;

    News(String type, String[] news, boolean isBreakingNews) {
        this.type = type;
        this.news = Arrays.stream(news, 2, news.length)
                    .collect(Collectors.joining(" "));

        this.isBreakingNews = isBreakingNews;
    }

    public String getType() {
        return type;
    }

    public String getNews() {
        return news;
    }

    public boolean isBreakingNews() {
        return isBreakingNews;
    }

    @Override
    public String toString() {
        return (isBreakingNews ? "BREAKING NEWS" : "NEWS") + " - " + type + " - " + news;
    }
}
