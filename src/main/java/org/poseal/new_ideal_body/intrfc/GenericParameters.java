package org.poseal.new_ideal_body.intrfc;

public interface GenericParameters extends IdealParameters, MacrocellsControlWeight, MacrocellsReductionWeight {

    public final int[][] PROTEIN_DATA = { { 19, 54, 66, 80, 93, 82, 97, 107, 126 },
            { 20, 56, 70, 82, 95, 84, 98, 113, 130 }, { 21, 56, 72, 85, 97, 86, 99, 115, 133 },
            { 22, 59, 73, 85, 100, 87, 102, 118, 133 }, { 23, 61, 74, 88, 102, 89, 104, 119, 137 },
            { 24, 61, 76, 89, 104, 92, 106, 122, 140 }, { 25, 62, 77, 92, 106, 92, 107, 125, 141 },
            { 26, 63, 78, 94, 108, 93, 110, 127, 143 }, { 27, 66, 81, 97, 110, 95, 110, 129, 147 },
            { 28, 66, 82, 97, 113, 97, 114, 131, 149 }, { 29, 67, 84, 98, 115, 98, 115, 132, 151 },
            { 30, 69, 84, 102, 117, 99, 118, 135, 154 }, { 31, 71, 87, 103, 119, 102, 119, 137, 157 },
            { 32, 72, 89, 105, 121, 104, 120, 139, 159 }, { 33, 74, 91, 106, 124, 105, 122, 141, 162 },
            { 34, 74, 93, 109, 126, 107, 125, 143, 162 }, { 35, 76, 95, 110, 128, 109, 127, 146, 165 },
            { 36, 77, 96, 113, 129, 110, 131, 148, 169 }, { 37, 80, 97, 115, 131, 111, 131, 150, 171 },
            { 38, 80, 99, 117, 133, 114, 132, 152, 173 }, { 39, 82, 102, 118, 136, 116, 135, 153, 176 },
            { 40, 83, 103, 120, 138, 117, 136, 155, 177 }, { 41, 85, 105, 122, 141, 119, 139, 159, 180 },
            { 42, 86, 106, 125, 143, 120, 140, 161, 183 }, { 43, 86, 108, 126, 146, 122, 141, 163, 185 },
            { 44, 88, 109, 128, 148, 125, 143, 165, 187 }, { 45, 89, 111, 130, 150, 127, 146, 168, 191 } };

    public final int[][] WEIGHT_WOMAN_DATA = {
            { 51, 51, 52, 52, 53, 54, 54, 55, 55, 56, 56, 57, 58, 58, 57, 59, 59, 60, 61, 61, 62, 62, 63, 64, 64, 65,
                    66, 67, 68, 68, 69, 70, 71, 72, 73, 74, 75 },
            { 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 52, 52, 53, 53, 54, 54, 55, 56, 56, 57, 57, 58, 59, 60, 60, 61,
                    62, 63, 64, 64, 65, 66, 67, 68, 68, 69, 69 },
            { 44, 44, 45, 45, 46, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 51, 52, 53, 53, 54, 54, 55, 56, 56, 57,
                    58, 58, 59, 60, 61, 62, 63, 64, 64, 65, 65 } };
    public final int[][] WEIGHT_MAN_DATA = {
            { 60, 61, 62, 63, 63, 64, 64, 65, 65, 66, 67, 67, 68, 69, 70, 71, 71, 72, 73, 74, 75, 75, 76, 77, 78, 79,
                    80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 88 },
            { 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 62, 62, 63, 64, 65, 65, 66, 67, 68, 69, 70, 70, 71, 72, 72, 73,
                    74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 82 },
            { 53, 53, 54, 54, 55, 55, 56, 56, 57, 57, 58, 58, 59, 60, 61, 62, 62, 64, 64, 65, 66, 66, 67, 68, 69, 70,
                    70, 71, 71, 72, 73, 74, 75, 76, 77, 78, 78 } };
    public final double[] FAT_WOMAN_DATA = { 22.1, 22, 22.7, 24, 25.6, 27.3, 28.2, 29.7, 30.7 };

    public final double[] FAT_MAN_DATA = { 14.9, 16.5, 18, 19.3, 20.5, 21.5, 22.1, 22.7, 23.3 };

    int indexMassBody();

    public int[] realProteinData();
}
