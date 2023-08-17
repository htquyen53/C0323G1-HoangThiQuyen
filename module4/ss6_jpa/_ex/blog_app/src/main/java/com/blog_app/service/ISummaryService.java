package com.blog_app.service;

import com.blog_app.model.summary.Summary;

import java.util.List;

public interface ISummaryService {
    List<Summary> showSummeryList();
    Summary save(Summary summary);
    boolean delete(Summary summary);

}
