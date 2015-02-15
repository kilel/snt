/*
 * Copyright 2015 Kislitsyn Ilya
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.kilel.jotter.ui.console.util;

import com.beust.jcommander.Parameter;

/**
 * Jcommander parameter definition for console command.
 */
public class ConsoleCommandParams {
    @Parameter (names = "-help", description = "Help", help = true)
    public boolean help;

    public static class Get extends ConsoleCommandParams {
        @Parameter (names = "-cat", description = "Category", arity = 1, required = true)
        public String category;

        @Parameter (names = "-name", description = "Name", arity = 1, required = true)
        public String name;
    }

    public static class Add extends Get {
        @Parameter (names = "-enc", description = "Encryptor code", arity = 1, required = true)
        public String encryptor;

        @Parameter (names = "-val", description = "Note value", arity = 1, password = true)
        public String value;

        @Parameter (names = "-encVal", description = "Encrypted value in Base64", arity = 1)
        public String encValue;
    }

    public static class Update extends Get {
        @Parameter (names = "-tgtCat", description = "New category", arity = 1)
        public String tgtCategory;

        @Parameter (names = "-tgtName", description = "New name", arity = 1)
        public String tgtName;

        @Parameter (names = "-encr", description = "New encryptor code", arity = 1)
        public String encryptor;

        @Parameter (names = "-val", description = "New note value", arity = 1, password = true)
        public String value;

        @Parameter (names = "-encVal", description = "Encrypted note value in Base64", arity = 1)
        public String encValue;
    }

    public static class Remove extends Get {
    }

    public static class List extends ConsoleCommandParams {
    }

    public static class Stop extends ConsoleCommandParams {
    }

    public static class Help extends ConsoleCommandParams {
    }

}