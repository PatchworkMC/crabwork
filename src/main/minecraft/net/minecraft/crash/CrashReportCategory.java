/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.crash;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class CrashReportCategory {
	@Shadow
	@Final
	private final CrashReport crashReport;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final List<CrashReportCategory.Entry> children;

	@Shadow
	private final StackTraceElement[] stackTrace;

	@Shadow
	public CrashReportCategory(CrashReport report, String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static String getCoordinateInfo(double x, double y, double z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static String getCoordinateInfo(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static String getCoordinateInfo(int x, int y, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void addBlockInfo(CrashReportCategory category, BlockPos pos, @Nullable BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CrashReportCategory addDetail(String nameIn, ICrashReportDetail<String> detail) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CrashReportCategory addDetail(String sectionName, Object value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addCrashSectionThrowable(String sectionName, Throwable throwable) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getPrunedStackTrace(int size) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean firstTwoElementsOfStackTraceMatch(StackTraceElement s1, StackTraceElement s2) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void trimStackTraceEntriesFromBottom(int amount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void appendToStringBuilder(StringBuilder builder) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public StackTraceElement[] getStackTrace() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void applyStackTrace(Throwable t) {
		throw new UnsupportedOperationException();
	}

	static class Entry {
		@Shadow
		@Final
		private final String key;

		@Shadow
		@Final
		private final String value;

		@Shadow
		public Entry(String key, @Nullable Object value) {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public String getKey() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getValue() {
			throw new UnsupportedOperationException();
		}
	}
}
