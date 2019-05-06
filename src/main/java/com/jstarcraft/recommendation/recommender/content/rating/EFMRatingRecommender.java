package com.jstarcraft.recommendation.recommender.content.rating;

import com.jstarcraft.ai.data.DataInstance;
import com.jstarcraft.recommendation.recommender.content.EFMRecommender;

/**
 * 
 * User KNN推荐器
 * 
 * <pre>
 * Explicit factor models for explainable recommendation based on phrase-level sentiment analysis
 * 参考LibRec团队
 * </pre>
 * 
 * @author Birdy
 *
 */
public class EFMRatingRecommender extends EFMRecommender {

    @Override
    public float predict(DataInstance instance) {
        int userIndex = instance.getQualityFeature(userDimension);
        int itemIndex = instance.getQualityFeature(itemDimension);
        float value = predict(userIndex, itemIndex);
        if (value < minimumOfScore)
            return minimumOfScore;
        if (value > maximumOfScore)
            return maximumOfScore;
        return value;
    }

}
