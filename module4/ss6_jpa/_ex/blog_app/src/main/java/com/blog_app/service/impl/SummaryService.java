package com.blog_app.service.impl;

import com.blog_app.model.summary.Summary;
import com.blog_app.repository.ISummaryRepository;
import com.blog_app.service.ISummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService implements ISummaryService {
    @Autowired
    private ISummaryRepository summaryRepository;

    @Override
    public List<Summary> showSummeryList() {
        return summaryRepository.findAll();
    }

    @Override
    public Summary save(Summary summary) {
        return summaryRepository.save(summary);
    }

    @Override
    public boolean delete(Summary summary) {
        try {
            summaryRepository.delete(summary);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
