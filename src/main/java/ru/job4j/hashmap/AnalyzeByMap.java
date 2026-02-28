package ru.job4j.hashmap;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totaLSum = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totaLSum += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects > 0 ? totaLSum / totalSubjects : 0D;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double sum = 0;
            List<Subject> subjects = pupil.subjects();

            for (Subject subject : subjects) {
                sum += subject.score();
            }

            double average = subjects.size() > 0 ? sum / subjects.size() : 0D;
            result.add(new Label(pupil.name(), average));
        }

        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> sumBySubject = new LinkedHashMap<>();
        Map<String, Integer> countBySubject = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();

                sumBySubject.put(subjectName, sumBySubject.getOrDefault(subjectName, 0) + score);
                countBySubject.put(subjectName, countBySubject.getOrDefault(subjectName, 0) + 1);
            }
        }

        List<Label> result = new ArrayList<>();
        for (String subjectName : sumBySubject.keySet()) {
            double average = (double) sumBySubject.get(subjectName) / countBySubject.get(subjectName);
            result.add(new Label(subjectName, average));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        double bestSum = -1;

        for (Pupil pupil : pupils) {
            double sum = 0;
            List<Subject> subjects = pupil.subjects();

            for (Subject subject : subjects) {
                sum += subject.score();
            }

            if (sum > bestSum) {
                bestSum = sum;
                best = new Label(pupil.name(), sum);
            }
        }

        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> sumBySubject = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                double score = subject.score();

                sumBySubject.put(subjectName,
                        sumBySubject.getOrDefault(subjectName, 0.0) + score);
            }
        }

        Label best = null;
        double bestSum = -1;

        for (Map.Entry<String, Double> entry : sumBySubject.entrySet()) {
            if (entry.getValue() > bestSum) {
                bestSum = entry.getValue();
                best = new Label(entry.getKey(), entry.getValue());
            }
        }

        return best;
    }

}